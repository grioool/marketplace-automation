package by.sam_solutions.grigorieva.olga.backend.controller;

import by.sam_solutions.grigorieva.olga.backend.entity.Role;
import by.sam_solutions.grigorieva.olga.backend.entity.TokenAuthentication;
import by.sam_solutions.grigorieva.olga.backend.entity.User;
import by.sam_solutions.grigorieva.olga.backend.service.user.UserService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;

@RestController
@RequiredArgsConstructor
public class UserController {

    @Value("${jwt.secret}")
    private String jwtSecret;

    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userService.getAll());
    }

    @PostMapping("/user/create")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/create").toUriString());
        return ResponseEntity.created(uri).body(userService.createUser(user));
    }

    @PostMapping("/role/create")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.createRole(role));
    }

    @PostMapping("/role/addtouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody NestedRole form) {
        userService.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "user/{userId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public User getUser(@PathVariable("userId") Integer id) {
        return userService.getById(id);
    }

    @RequestMapping(value = "/user",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @RequestMapping(value = "/user/{userId}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public void delete(@PathVariable("userId") int id) {
        userService.delete(id);
    }

    @GetMapping("/token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            try {

                String refresh_token = authorizationHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC512(jwtSecret);
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(refresh_token);
                String username = decodedJWT.getSubject();
                User user = userService.getByUsername(username);

                new ObjectMapper().writeValue(response.getOutputStream(),
                        TokenAuthentication.builder()
                                .accessToken(
                                        JWT.create()
                                                .withSubject(user.getUsername())
                                                .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                                                .withClaim("roles", user.getRoles().stream().map(Role::getRoleName).collect(Collectors.toList()))
                                                .sign(algorithm)
                                )
                                .refreshToken(refresh_token)
                                .build());

            } catch (Exception exception) {

                response.setHeader("error", exception.getMessage());
                response.setStatus(FORBIDDEN.value());
                //response.sendError(FORBIDDEN.value());
                Map<String, String> error = new HashMap<>();
                error.put("error_message", exception.getMessage());
                response.setContentType(MimeTypeUtils.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);

            }
        } else {
            throw new RuntimeException("Refresh token is missing");
        }
    }

}

@Data
class NestedRole {
    private String username;
    private String roleName;
}
