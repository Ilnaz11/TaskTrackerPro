package ru.baymukhametov.TaskTrackerPro.dto;

import lombok.Data;
import ru.baymukhametov.TaskTrackerPro.Entity.TaskStatus;

@Data
public class TaskStatusUpdateDto {
    private TaskStatus status;
}