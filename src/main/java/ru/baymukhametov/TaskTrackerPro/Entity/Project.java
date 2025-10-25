package ru.baymukhametov.TaskTrackerPro.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    @OneToMany(mappedBy = "project_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> tasks;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private User manager;
}
