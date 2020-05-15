package ru.itis.group11801.moviehubrest.services;

import ru.itis.group11801.moviehubrest.dto.UserDto;

import java.util.List;

public interface UsersService {
    List<UserDto> getAllUsers();

    void deleteUser(Long userId);
}
