package ru.baymukhametov.TaskTrackerPro.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.baymukhametov.TaskTrackerPro.Entity.Project;
import ru.baymukhametov.TaskTrackerPro.Entity.Task;
import ru.baymukhametov.TaskTrackerPro.Entity.TaskStatus;
import ru.baymukhametov.TaskTrackerPro.Entity.User;
import ru.baymukhametov.TaskTrackerPro.Repository.ProjectRepository;
import ru.baymukhametov.TaskTrackerPro.Repository.TaskRepository;
import ru.baymukhametov.TaskTrackerPro.Repository.UserRepository;
import ru.baymukhametov.TaskTrackerPro.dto.TaskCreateDto;
import ru.baymukhametov.TaskTrackerPro.dto.TaskResponseDto;
import ru.baymukhametov.TaskTrackerPro.dto.TaskStatsDto;
import ru.baymukhametov.TaskTrackerPro.mapper.TaskMapper;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Override
    public TaskResponseDto createTask(Task task) {
        Task task1 = taskRepository.save(task);
        return taskMapper.toDto(task1);
    }

    @Override
    public List<TaskResponseDto> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return taskMapper.toDtoList(tasks);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<TaskResponseDto> getTaskFromUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found User"));
        List<Task> tasks = taskRepository.findByExecutor(user);

        return taskMapper.toDtoList(tasks);
    }

    @Override
    public List<TaskResponseDto> getTaskFromStatus(TaskStatus taskStatus) {
        List<Task> task = taskRepository.findByStatus(taskStatus);
        return taskMapper.toDtoList(task);
    }

    @Override
    public Optional<TaskResponseDto> findById(Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        Task task = optionalTask.orElseThrow(() -> new RuntimeException("Not found Task id: " + id));

        return optionalTask.map(taskMapper::toDto);
    }

    @Override
    public TaskResponseDto updateTask(Long id, TaskCreateDto taskCreateDto) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        if (taskCreateDto.getTitle() != null) {
            task.setTitle(taskCreateDto.getTitle());
        }
        if (taskCreateDto.getDescription() != null) {
            task.setDescription(taskCreateDto.getDescription());
        }
        if (taskCreateDto.getDueDate() != null) {
            task.setDueDate(taskCreateDto.getDueDate());
        }
        if (taskCreateDto.getStatus() != null) {
            task.setStatus(taskCreateDto.getStatus());
        }

        return taskMapper.toDto(taskRepository.save(task));

    }

    @Override
    public List<TaskResponseDto> getTasksFromProject(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found Project"));
        List<Task> tasks = taskRepository.findByProject(project);
        return taskMapper.toDtoList(tasks);
    }

    @Override
    public Page<TaskResponseDto> getPagedTasks(Long id, Pageable pageable) {
        Page<Task> tasks = taskRepository.findByTaskId(id, pageable);
        return tasks.map(taskMapper::toDto);
    }

    @Override
    public TaskStatsDto getStats(TaskStatus status) {
        long totalTasks = taskRepository.count();
        long newTasks = taskRepository.countByStatus(TaskStatus.NEW);
        long inProgressTasks = taskRepository.countByStatus(TaskStatus.IN_PROGRESS);
        long doneTasks = taskRepository.countByStatus(TaskStatus.DONE);

        return new TaskStatsDto(totalTasks, newTasks, inProgressTasks, doneTasks);
    }
}

