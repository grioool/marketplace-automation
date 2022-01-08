package by.sam_solutions.grigorieva.olga.backend.controller.auth_registration;

import by.sam_solutions.grigorieva.olga.backend.config.jwt.JwtProvider;
import by.sam_solutions.grigorieva.olga.backend.entity.User;
import by.sam_solutions.grigorieva.olga.backend.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public void register(@RequestBody @Valid RegistrationRequest registrationRequest) {
        User user = new User();
        user.setPassword(registrationRequest.getPassword());
        user.setUsername(registrationRequest.getUsername());
        user.setEmail(registrationRequest.getEmail());
        user.setNameCompany(registrationRequest.getNameCompany());
        user.setWildBerriesKeys(registrationRequest.getWbKey());
        user.setOzonKey(registrationRequest.getOzonKey());
        userService.register(user);
    }

    @PostMapping("/login")
    public AuthResponse auth(@RequestBody AuthRequest request) {
        return new AuthResponse(userService.authenticate(request.getUsername(), request.getPassword()));
    }
}
