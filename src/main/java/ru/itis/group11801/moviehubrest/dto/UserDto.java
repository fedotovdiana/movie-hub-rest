package ru.itis.group11801.moviehubrest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.group11801.moviehubrest.model.User;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDto {

    private Long id;
    private String name;
    private String login;

    public static UserDto from(User user) {
        return UserDto.builder()
                .login(user.getLogin())
                .name(user.getName())
                .id(user.getId())
                .build();
    }

    public static List<UserDto> from(List<User> users) {
        return users.stream()
                .map(UserDto::from)
                .collect(Collectors.toList());
    }
}
