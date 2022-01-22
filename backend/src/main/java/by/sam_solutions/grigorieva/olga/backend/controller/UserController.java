package by.sam_solutions.grigorieva.olga.backend.controller;

import by.sam_solutions.grigorieva.olga.backend.controller.registration.RegistrationController;
import by.sam_solutions.grigorieva.olga.backend.dto.RoleDto;
import by.sam_solutions.grigorieva.olga.backend.dto.UserDto;
import by.sam_solutions.grigorieva.olga.backend.dto.UserRoleDto;
import by.sam_solutions.grigorieva.olga.backend.entity.Role;
import by.sam_solutions.grigorieva.olga.backend.entity.TokenAuthentication;
import by.sam_solutions.grigorieva.olga.backend.entity.User;
import by.sam_solutions.grigorieva.olga.backend.service.user.UserService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
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
    private final Logger logger = LoggerFactory.getLogger(UserController.class);


    @GetMapping("/users")
    public List<UserDto> getUsers() {
        logger.info("Getting users...");
        return userService.getAll().stream()
                .map(UserDto::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/user")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        logger.info("Getting user...");
        User user = UserDto.toEntity(userDto);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/user").toUriString());
        return ResponseEntity.created(uri).body(UserDto.toDto(userService.createUser(user)));
    }

    @PostMapping("/role")
    public ResponseEntity<RoleDto> createRole(@RequestBody RoleDto roleDto) {
        logger.info("Creating role...");
        Role role = RoleDto.toEntity(roleDto);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/role").toUriString());
        return ResponseEntity.created(uri).body(RoleDto.toDto(userService.createRole(role)));
    }

    @PostMapping("/role/addtouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody UserRoleDto dto) {
        logger.info("Adding role to user...");
        return ResponseEntity.ok().body(userService.addRoleToUser(dto.getUsername(), dto.getRoleName()));
    }

    @GetMapping( "/user/{userId}")
    public UserDto getUser(@PathVariable("userId") Integer id) {
        logger.info("Getting user...");
        return UserDto.toDto(userService.getById(id));
    }

    @PutMapping(value = "/user")
    public UserDto update(@RequestBody UserDto userDto) {
        logger.info("Updating user...");
        User user = UserDto.toEntity(userDto);
        return UserDto.toDto(userService.update(user));
    }

    @DeleteMapping(value = "/user/{userId}")
    public void delete(@PathVariable("userId") int id) {
        logger.info("Deleting users...");
        userService.delete(id);
        logger.error("Deleted.");
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
                response.sendError(FORBIDDEN.value());
                Map<String, String> error = new HashMap<>();
                logger.error(exception.getMessage());
                error.put("error_message", exception.getMessage());
                response.setContentType(MimeTypeUtils.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);
            }
        } else {
            throw new RuntimeException("Refresh token is missing");
        }
    }

}

