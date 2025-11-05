package ru.baymukhametov.TaskTrackerPro.Service;

import org.springframework.stereotype.Service;
import ru.baymukhametov.TaskTrackerPro.Entity.Task;
import ru.baymukhametov.TaskTrackerPro.Entity.TaskStatus;
import ru.baymukhametov.TaskTrackerPro.dto.TaskCreateDto;
import ru.baymukhametov.TaskTrackerPro.dto.TaskResponseDto;
import ru.baymukhametov.TaskTrackerPro.dto.TaskStatusUpdateDto;

import java.util.List;
import java.util.Optional;

@Service
public interface TaskService {

    TaskResponseDto createTask(Task task);
    List<TaskResponseDto> getAllTasks();
    void deleteTask(Long id);
    List<TaskResponseDto> getTaskFromUser(Long id);
    List<TaskResponseDto> getTaskFromStatus(TaskStatus taskStatus);
    Optional<TaskResponseDto> findById(Long id);
    TaskResponseDto updateTask(Long id, TaskCreateDto taskCreateDto, TaskStatusUpdateDto taskStatusUpdateDto);
}

//2.	/tasks/assignee/{userId} — получить задачи определённого пользователя.