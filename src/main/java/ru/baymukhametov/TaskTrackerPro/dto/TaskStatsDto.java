package ru.baymukhametov.TaskTrackerPro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskStatsDto {
    private long totalTasks;
    private long newTasks;
    private long inProgressTasks;
    private long doneTasks;

}