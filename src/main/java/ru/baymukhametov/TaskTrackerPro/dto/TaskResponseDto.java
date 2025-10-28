package ru.baymukhametov.TaskTrackerPro.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskResponseDto {
    private String title;
    private String description;
    private LocalDateTime dueDate;
}
