package by.sam_solutions.grigorieva.olga.backend.controller.auth_registration;

import by.sam_solutions.grigorieva.olga.backend.config.jwt.JwtProvider;
import by.sam_solutions.grigorieva.olga.backend.entity.User;
import by.sam_solutions.grigorieva.olga.backend.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/register")
    public String register(@RequestBody @Valid RegistrationRequest registrationRequest) {
        User user = new User();
        user.setPassword(registrationRequest.getPassword());
        user.setUsername(registrationRequest.getLogin());
        userService.create(user);
        return "OK";
    }

    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody AuthRequest request) {
        User userEntity = userService.getByUsernameAndPassword(request.getLogin(), request.getPassword());
        String token = jwtProvider.generateToken(userEntity.getUsername());
        return new AuthResponse(token);
    }
}
