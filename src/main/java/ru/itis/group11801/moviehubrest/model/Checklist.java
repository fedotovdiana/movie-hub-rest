package ru.itis.group11801.moviehubrest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "moviechecklists")
public class Checklist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer size;

    @Transient
    private String fullName;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @PostLoad
    public void addFullName() {
        fullName = name + " of " + owner.getName();
        System.out.println(fullName);
    }
}