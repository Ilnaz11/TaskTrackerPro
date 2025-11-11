package ru.baymukhametov.TaskTrackerPro.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.baymukhametov.TaskTrackerPro.Entity.Task;
import ru.baymukhametov.TaskTrackerPro.Entity.TaskStatus;
import ru.baymukhametov.TaskTrackerPro.dto.TaskCreateDto;
import ru.baymukhametov.TaskTrackerPro.dto.TaskResponseDto;
import ru.baymukhametov.TaskTrackerPro.dto.TaskStatsDto;

import java.util.List;
import java.util.Optional;


public interface TaskService {

    TaskResponseDto createTask(Task task);
    List<TaskResponseDto> getAllTasks();
    void deleteTask(Long id);
    List<TaskResponseDto> getTaskFromUser(Long id);
    List<TaskResponseDto> getTaskFromStatus(TaskStatus taskStatus);
    Optional<TaskResponseDto> findById(Long id);
    TaskResponseDto updateTask(Long id, TaskCreateDto taskCreateDto);
    List<TaskResponseDto> getTasksFromProject(Long id);
    Page<TaskResponseDto> getPagedTasks(Long id, Pageable pageable);
    TaskStatsDto getStats(TaskStatus taskStatus);
}