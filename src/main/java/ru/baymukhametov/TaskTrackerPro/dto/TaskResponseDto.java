package ru.baymukhametov.TaskTrackerPro.dto;

import lombok.Data;
import ru.baymukhametov.TaskTrackerPro.Entity.TaskStatus;

import java.time.LocalDateTime;

@Data
public class TaskResponseDto {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime dueDate;
    private TaskStatus taskStatus;
}
