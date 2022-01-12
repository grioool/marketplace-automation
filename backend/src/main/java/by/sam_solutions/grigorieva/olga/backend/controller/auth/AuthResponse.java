package by.sam_solutions.grigorieva.olga.backend.controller.auth;

import by.sam_solutions.grigorieva.olga.backend.entity.TokenAuthentication;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {

    private TokenAuthentication token;
}
