package ru.baymukhametov.TaskTrackerPro.Service;

import org.springframework.stereotype.Service;
import ru.baymukhametov.TaskTrackerPro.Entity.Task;
import ru.baymukhametov.TaskTrackerPro.dto.TaskCreateDto;

import java.util.Optional;

@Service
public interface TaskService {

    TaskCreateDto createTask(Task task);
    void deleteTask(Long id);
    Optional<TaskCreateDto> findById(Long id);
    TaskCreateDto updateTask(Long id, TaskCreateDto taskCreateDto);
}

