package by.sam_solutions.grigorieva.olga.backend.controller.auth;

import by.sam_solutions.grigorieva.olga.backend.controller.auth.dto.UserLoginDto;
import by.sam_solutions.grigorieva.olga.backend.controller.auth.dto.UserRegistrationDto;
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
    public void register(@RequestBody @Valid UserRegistrationDto userDto) {
        User user = new User();
        user.setPassword(userDto.getPassword());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setNameCompany(userDto.getNameCompany());
        user.setWildBerriesKeys(userDto.getWbKey());
        user.setOzonKey(userDto.getOzonKey());
        userService.register(user);
    }

    @PostMapping("/login")
    public AuthResponse auth(@RequestBody UserLoginDto userDto) {
        return new AuthResponse(userService.authenticate(userDto.getUsername(), userDto.getPassword()));
    }
}
