package ru.baymukhametov.TaskTrackerPro.dto;

import lombok.Data;

@Data
public class ProjectCreateDto {
    private String name;
    private String description;
    private Long managerId;
}
