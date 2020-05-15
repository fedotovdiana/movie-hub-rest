package ru.itis.group11801.moviehubrest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.group11801.moviehubrest.dto.SignInDto;
import ru.itis.group11801.moviehubrest.dto.TokenDto;
import ru.itis.group11801.moviehubrest.services.SignInService;

@RestController
public class SignInRestController {

    @Autowired
    private SignInService signInService;

    @PostMapping("/signIn")
    public ResponseEntity<TokenDto> signIn(@RequestBody SignInDto signInData) {
        return ResponseEntity.ok(signInService.signIn(signInData));
    }
}
