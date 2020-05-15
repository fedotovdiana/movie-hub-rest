package ru.itis.group11801.moviehubrest.services;

import ru.itis.group11801.moviehubrest.dto.SignInDto;
import ru.itis.group11801.moviehubrest.dto.TokenDto;

public interface SignInService {
    TokenDto signIn(SignInDto signInData);
}
