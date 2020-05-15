package ru.itis.group11801.moviehubrest.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.group11801.moviehubrest.dto.SignInDto;
import ru.itis.group11801.moviehubrest.dto.TokenDto;
import ru.itis.group11801.moviehubrest.model.User;
import ru.itis.group11801.moviehubrest.repositories.UsersRepository;

import java.util.Optional;

@Slf4j
@Service
public class SignInServiceImpl implements SignInService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${jwt.secret}")
    private String secret;

    @Override
    public TokenDto signIn(SignInDto signInData) {
        Optional<User> userOptional = usersRepository.findUserByLogin(signInData.getLogin());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (passwordEncoder.matches(signInData.getPassword(), user.getHashPassword())) {
                String token = Jwts.builder()
                        .setSubject(user.getId().toString())
                        .claim("name", user.getName())
                        .claim("role", user.getRole().name())
                        .signWith(SignatureAlgorithm.HS256, secret)
                        .compact();
                System.out.println(token);
                return new TokenDto(token);
            } else {
                throw new AccessDeniedException("Wrong login/password");
            }
        } else throw new AccessDeniedException("User not found");
    }
}
