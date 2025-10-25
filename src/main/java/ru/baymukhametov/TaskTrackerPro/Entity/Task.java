package ru.baymukhametov.TaskTrackerPro.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime dueDate;
    @Enumerated(EnumType.STRING)
    private TaskStatus status = TaskStatus.NEW;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User rightHolder;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
}

