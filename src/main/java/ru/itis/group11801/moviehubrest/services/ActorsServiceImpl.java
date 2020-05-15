package ru.itis.group11801.moviehubrest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.group11801.moviehubrest.dto.ActorDto;
import ru.itis.group11801.moviehubrest.repositories.ActorsRepository;

import java.util.List;

@Service
public class ActorsServiceImpl implements ActorsService {

    @Autowired
    ActorsRepository actorsRepository;

    @Override
    public List<ActorDto> getActors() {
        return ActorDto.from(actorsRepository.findAll());
    }
}
