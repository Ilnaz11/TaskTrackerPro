package ru.baymukhametov.TaskTrackerPro.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskCreateDto {
    private String title;
    private String description;
    private LocalDateTime dueDate;
    private Long projectId;
    private Long executorId;
}