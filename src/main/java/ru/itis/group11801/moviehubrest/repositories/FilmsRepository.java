package ru.itis.group11801.moviehubrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.group11801.moviehubrest.model.Film;

public interface FilmsRepository extends JpaRepository<Film, Long> {}
