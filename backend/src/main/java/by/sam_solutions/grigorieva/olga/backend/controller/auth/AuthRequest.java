package by.sam_solutions.grigorieva.olga.backend.controller.auth;

import lombok.Data;

@Data
public class AuthRequest {
    private String login;
    private String password;
}
