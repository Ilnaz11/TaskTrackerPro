package ru.baymukhametov.TaskTrackerPro.mapper;

import org.springframework.stereotype.Component;
import ru.baymukhametov.TaskTrackerPro.Entity.Project;
import ru.baymukhametov.TaskTrackerPro.Entity.Task;
import ru.baymukhametov.TaskTrackerPro.Entity.User;
import ru.baymukhametov.TaskTrackerPro.dto.TaskCreateDto;
import ru.baymukhametov.TaskTrackerPro.dto.TaskResponseDto;

import java.util.List;

@Component
public class TaskMapper {

    public TaskResponseDto toDto(Task task) {
        if (task == null) {
            return null;
        }
        TaskResponseDto taskResponseDto = new TaskResponseDto();
        taskResponseDto.setTitle(task.getTitle());
        taskResponseDto.setDescription(task.getDescription());
        taskResponseDto.setDueDate(task.getDueDate());
        taskResponseDto.setStatus(task.getStatus());

        if (task.getTaskId() != null) {
            taskResponseDto.setId(task.getTaskId());
        }

        if (task.getProject() != null) {
            taskResponseDto.setProject_id(task.getProject().getId());
        }
        if (task.getExecutor() != null) {
            taskResponseDto.setExecutor_id(task.getExecutor().getId());
        }
        return taskResponseDto;
    }
//
//    public Task toEntity(TaskCreateDto taskCreateDto) {
//        if(taskCreateDto == null) {
//            return null;
//        }
//
//        Task task = new Task();
//        task.setTitle(taskCreateDto.getTitle());
//        task.setDescription(taskCreateDto.getDescription());
//        task.setDueDate(taskCreateDto.getDueDate());
//        task.setStatus(taskCreateDto.getTaskStatus());
//
//        if (taskCreateDto.getProject_id() != null) {
//            task.setTaskId(taskCreateDto.getProject_id());
//        }
//        if (taskCreateDto.getExecutor_id() != null) {
//            task.setTaskId(taskCreateDto.getProject_id());
//        }
//        return task;
//    }

    public List<TaskResponseDto> toDtoList(List<Task> tasks) {
        if (tasks == null) {
            return null;
        }
        return tasks.stream()
                .map(this::toDto)
                .toList();
    }
}
