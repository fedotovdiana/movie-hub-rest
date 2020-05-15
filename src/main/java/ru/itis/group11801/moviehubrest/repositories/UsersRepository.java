package ru.itis.group11801.moviehubrest.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.group11801.moviehubrest.model.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByLogin(String login);
}
