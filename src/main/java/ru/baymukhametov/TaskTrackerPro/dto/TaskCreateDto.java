package ru.baymukhametov.TaskTrackerPro.dto;

import lombok.Data;
import ru.baymukhametov.TaskTrackerPro.Entity.TaskStatus;


@Data
public class TaskCreateDto {
    private String title;
    private String description;
    private TaskStatus status;
    private Long project_id;
    private Long executor_id;
}