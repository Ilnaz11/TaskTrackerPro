package ru.baymukhametov.TaskTrackerPro.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.baymukhametov.TaskTrackerPro.Entity.Task;
import ru.baymukhametov.TaskTrackerPro.Repository.TaskRepository;
import ru.baymukhametov.TaskTrackerPro.dto.TaskCreateDto;
import ru.baymukhametov.TaskTrackerPro.mapper.TaskMapper;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Override
    public TaskCreateDto createTask(Task task) {
        return taskMapper.toDto(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Optional<TaskCreateDto> findById(Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        Task task = optionalTask.orElseThrow(() -> new RuntimeException("Not found Task"));

        return optionalTask.map(taskMapper::toDto);
    }

    @Override
    public TaskCreateDto updateTask(Long id, TaskCreateDto taskCreateDto) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found Task"));

        if (taskCreateDto.getTitle() != null) {
            task.setTitle(taskCreateDto.getTitle());
        }
        if (taskCreateDto.getDescription() != null) {
            task.setDescription(taskCreateDto.getDescription());
        }
        if (taskCreateDto.getDueDate() != null) {
            task.setDueDate(taskCreateDto.getDueDate());
        }

        Task task1 = taskRepository.save(task);
        return taskMapper.toDto(task1);
    }
}
