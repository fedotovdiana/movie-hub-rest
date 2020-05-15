package ru.itis.group11801.moviehubrest.services;

import ru.itis.group11801.moviehubrest.dto.ChecklistDto;

import java.util.List;

public interface ChecklistsService {
    void init();

    List<ChecklistDto> getAll();
}
