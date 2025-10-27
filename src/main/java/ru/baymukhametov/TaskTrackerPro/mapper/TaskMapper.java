package ru.baymukhametov.TaskTrackerPro.mapper;

import ru.baymukhametov.TaskTrackerPro.Entity.Task;
import ru.baymukhametov.TaskTrackerPro.dto.TaskCreateDto;

public class TaskMapper {

    public TaskCreateDto toDto(Task task) {
        if (task == null) {
            return null;
        }
        TaskCreateDto taskCreateDto = new TaskCreateDto();
        taskCreateDto.setDescription(task.getDescription());
        taskCreateDto.setTitle(task.getTitle());
        taskCreateDto.setDueDate(task.getDueDate());

        if (task.getProject() != null) {
            taskCreateDto.setProjectId(task.getProject().getId());
        }
        if (task.getExecutor() != null) {
            taskCreateDto.setExecutorId(task.getExecutor().getId());
        }
        return taskCreateDto;
    }
}
