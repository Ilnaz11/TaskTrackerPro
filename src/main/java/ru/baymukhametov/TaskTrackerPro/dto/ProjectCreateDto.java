package ru.baymukhametov.TaskTrackerPro.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProjectCreateDto {
    private String name;
    private String description;
    private Long managerId;
}
