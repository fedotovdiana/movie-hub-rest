package ru.itis.group11801.moviehubrest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.group11801.moviehubrest.dto.FilmDto;
import ru.itis.group11801.moviehubrest.repositories.FilmsRepository;

import java.util.List;

@Service
public class FilmsServiceImpl implements FilmsService {

    @Autowired
    FilmsRepository filmsRepository;

    @Override
    public List<FilmDto> getFilms() {
        return FilmDto.from(filmsRepository.findAll());
    }

    @Override
    public FilmDto getConcreteFilm(Long id) {
        return FilmDto.from(filmsRepository.getOne(id));
    }
}
