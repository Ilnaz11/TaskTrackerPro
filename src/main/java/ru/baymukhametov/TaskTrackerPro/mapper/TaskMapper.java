package ru.baymukhametov.TaskTrackerPro.mapper;

import ru.baymukhametov.TaskTrackerPro.Entity.Task;
import ru.baymukhametov.TaskTrackerPro.dto.TaskResponseDto;

import java.util.List;

public class TaskMapper {

    public TaskResponseDto toDto(Task task) {
        if (task == null) {
            return null;
        }
        TaskResponseDto taskResponseDto = new TaskResponseDto();
        taskResponseDto.setDescription(task.getDescription());
        taskResponseDto.setTitle(task.getTitle());
        taskResponseDto.setDueDate(task.getDueDate());
        taskResponseDto.setTaskStatus(task.getStatus());

        if (task.getProject() != null) {
            taskResponseDto.setId(task.getProject().getId());
        }
        if (task.getExecutor() != null) {
            taskResponseDto.setId(task.getExecutor().getId());
        }
        return taskResponseDto;
    }

    public List<TaskResponseDto> toDtoList(List<Task> tasks) {
        if (tasks == null) {
            return null;
        }
        return tasks.stream()
                .map(this::toDto)
                .toList();
    }
}
