package ru.itis.group11801.moviehubrest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.group11801.moviehubrest.model.Checklist;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ChecklistDto {

    private Long id;
    private String name;
    private Integer size;
    private String fullName;

    public static ChecklistDto from(Checklist checklist) {
        return ChecklistDto.builder()
                .fullName(checklist.getFullName())
                .size(checklist.getSize())
                .name(checklist.getName())
                .id(checklist.getId())
                .build();
    }

    public static List<ChecklistDto> from(List<Checklist> checklists) {
        return checklists.stream()
                .map(ChecklistDto::from)
                .collect(Collectors.toList());
    }
}
