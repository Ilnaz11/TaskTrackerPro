package ru.baymukhametov.TaskTrackerPro.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProjectResponseDto {
    private String name;
    private String description;
    private Long managerId;
    private LocalDateTime dueDate;
    private LocalDateTime createdAt;
}
