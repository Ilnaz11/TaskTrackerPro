package ru.baymukhametov.TaskTrackerPro.dto;

import lombok.Data;
import ru.baymukhametov.TaskTrackerPro.Entity.TaskStatus;

import java.time.LocalDateTime;

@Data
public class TaskCreateDto {
    private String title;
    private String description;
    private LocalDateTime dueDate;
    private TaskStatus status;
    private Long projectId;
    private Long executorId;
}