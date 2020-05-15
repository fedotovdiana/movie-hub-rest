package ru.itis.group11801.moviehubrest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.group11801.moviehubrest.dto.FilmDto;
import ru.itis.group11801.moviehubrest.services.FilmsService;

import java.util.List;

@RestController
public class FilmsController {

    @Autowired
    FilmsService filmsService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/films")
    public ResponseEntity<List<FilmDto>> getFilms() {
        return ResponseEntity.ok(filmsService.getFilms());
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/films/{film_id}")
    public ResponseEntity<FilmDto> getFilms(@PathVariable Long film_id) {
        return ResponseEntity.ok(filmsService.getConcreteFilm(film_id));
    }
}
