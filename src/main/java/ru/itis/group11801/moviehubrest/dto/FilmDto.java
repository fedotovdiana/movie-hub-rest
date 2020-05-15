package ru.itis.group11801.moviehubrest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.group11801.moviehubrest.model.Film;
import ru.itis.group11801.moviehubrest.model.User;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FilmDto {

    private Long id;
    private String name;
    private String country;

    public static FilmDto from(Film film) {
        return FilmDto.builder()
                .country(film.getCountry())
                .name(film.getName())
                .id(film.getId())
                .build();
    }

    public static List<FilmDto> from(List<Film> films) {
        return films.stream()
                .map(FilmDto::from)
                .collect(Collectors.toList());
    }
}

