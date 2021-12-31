package by.sam_solutions.grigorieva.olga.backend.controller;

import lombok.Data;

@Data
public class AuthRequest {
    private String login;
    private String password;
}
