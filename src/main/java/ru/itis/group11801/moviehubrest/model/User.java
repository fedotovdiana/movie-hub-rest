package ru.itis.group11801.moviehubrest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String login;
    @Column(name = "password")
    private String hashPassword;
    private LocalDateTime createdAt;
    private String photo;
    private String confirmCode;

    @Enumerated(value = EnumType.STRING)
    private State state;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "owner")
    @Where(clause = "size = 1")
    private List<Checklist> shortChecklists;

    @OneToMany(mappedBy = "owner")
    private List<Checklist> checklists;
}
