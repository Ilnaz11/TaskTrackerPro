package ru.baymukhametov.TaskTrackerPro.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.baymukhametov.TaskTrackerPro.Entity.Task;
import ru.baymukhametov.TaskTrackerPro.Repository.TaskRepository;
import ru.baymukhametov.TaskTrackerPro.dto.TaskCreateDto;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final

    @Override
    public TaskCreateDto createTask(Task task) {
        return
    }

    @Override
    public void deleteTask(Long id) {

    }

    @Override
    public Optional<Task> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public TaskCreateDto updateTask(Long id, TaskCreateDto taskCreateDto) {
        return null;
    }
}
