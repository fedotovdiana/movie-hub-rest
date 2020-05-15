package ru.itis.group11801.moviehubrest.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.group11801.moviehubrest.dto.ActorDto;
import ru.itis.group11801.moviehubrest.services.ActorsService;

import java.util.List;

@RestController
@Slf4j
public class ActorsController {

    @Autowired
    ActorsService actorsService;

    @GetMapping("/actors")
    public ResponseEntity<List<ActorDto>> getActors() {
        return ResponseEntity.ok(actorsService.getActors());
    }
}
