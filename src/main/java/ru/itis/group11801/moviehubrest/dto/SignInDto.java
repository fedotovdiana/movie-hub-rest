package ru.itis.group11801.moviehubrest.dto;

import lombok.Data;

@Data
public class SignInDto {
    private String login;
    private String password;
}
