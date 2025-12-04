package ru.baymukhametov.TaskTrackerPro.Service;

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


@Service
public class TaskServiceImpl implements TaskService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;


    public TaskServiceImpl(ProjectRepository projectRepository,
                           UserRepository userRepository,
                           TaskRepository taskRepository,
                           TaskMapper taskMapper) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskResponseDto createTask(TaskCreateDto taskCreateDto) {
        Long project_id = taskCreateDto.getProject_id();
        Long executorId = taskCreateDto.getExecutor_id();

        Project project = projectRepository.findById(project_id)
                .orElseThrow(() -> new RuntimeException("Not found project id: " + project_id));

        User user = userRepository.findById(executorId)
                .orElseThrow(() -> new RuntimeException("Not found Executor: " + executorId));

        Task task = new Task();

        task.setTitle(taskCreateDto.getTitle());
        task.setDescription(taskCreateDto.getDescription());
        task.setDueDate(taskCreateDto.getDueDate());
        task.setStatus(taskCreateDto.getStatus());

        if (task.getStatus() == null) {
            task.setStatus(TaskStatus.NEW);
        }

        task.setProject(project);
        task.setExecutor(user);

        Task savedTask = taskRepository.save(task);


        return taskMapper.toDto(savedTask);
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
    public List<TaskResponseDto> getTaskFromUser(Long userId) {
        User executor = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Not found User"));

        List<Task> tasks = taskRepository.findByExecutor(executor);

        return taskMapper.toDtoList(tasks);
    }

    @Override
    public List<TaskResponseDto> getTaskFromStatus(TaskStatus status) {
        List<Task> task = taskRepository.findByStatus(status);
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
    public TaskStatsDto getStats() {
        long totalTasks = taskRepository.count();
        long newTasks = taskRepository.countByStatus(TaskStatus.NEW);
        long inProgressTasks = taskRepository.countByStatus(TaskStatus.IN_PROGRESS);
        long doneTasks = taskRepository.countByStatus(TaskStatus.DONE);

        return new TaskStatsDto(totalTasks, newTasks, inProgressTasks, doneTasks);
    }
}