package ru.itis.group11801.moviehubrest.services;

import ru.itis.group11801.moviehubrest.dto.FilmDto;

import java.util.List;

public interface FilmsService {
    List<FilmDto> getFilms();
    FilmDto getConcreteFilm(Long id);
}
