package ru.itis.group11801.moviehubrest.services;

import ru.itis.group11801.moviehubrest.dto.ActorDto;

import java.util.List;

public interface ActorsService {
    List<ActorDto> getActors();
}
