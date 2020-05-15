package ru.itis.group11801.moviehubrest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.group11801.moviehubrest.model.Actor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ActorDto {

    private Long id;
    private String name;
    private String country;

    public static ActorDto from(Actor actor) {
        return ActorDto.builder()
                .country(actor.getCountry())
                .name(actor.getName())
                .id(actor.getId())
                .build();
    }

    public static List<ActorDto> from(List<Actor> actors) {
        return actors.stream()
                .map(ActorDto::from)
                .collect(Collectors.toList());
    }
}
