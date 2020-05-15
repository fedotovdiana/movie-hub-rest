package ru.itis.group11801.moviehubrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.group11801.moviehubrest.model.Checklist;

public interface ChecklistsRepository extends JpaRepository<Checklist, Long> { }
