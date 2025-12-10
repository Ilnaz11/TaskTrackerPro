package ru.baymukhametov.TaskTrackerPro.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;
    private String title;
    private String description;
    private LocalDateTime created_At;
    private LocalDateTime dueDate;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @ManyToOne
    @JoinColumn(name = "executor_id")
    private User executor;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
}

