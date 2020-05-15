package ru.itis.group11801.moviehubrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.group11801.moviehubrest.model.Actor;

public interface ActorsRepository extends JpaRepository<Actor, Long> { }
