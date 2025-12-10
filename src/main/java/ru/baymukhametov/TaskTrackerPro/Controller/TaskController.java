package ru.baymukhametov.TaskTrackerPro.Controller;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ru.baymukhametov.TaskTrackerPro.Entity.TaskStatus;
import ru.baymukhametov.TaskTrackerPro.Service.TaskService;
import ru.baymukhametov.TaskTrackerPro.dto.TaskCreateDto;
import ru.baymukhametov.TaskTrackerPro.dto.TaskResponseDto;
import ru.baymukhametov.TaskTrackerPro.dto.TaskStatsDto;

import java.util.List;
import java.util.Optional;

@RequestMapping("/tasks")
@RestController
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;

    }

    @PostMapping
    public TaskResponseDto createTask(@Valid @RequestBody TaskCreateDto task) {
        return taskService.createTask(task);
    }

    @GetMapping("/{id}")
    public Optional<TaskResponseDto> findTaskById(@PathVariable Long id) {
        return taskService.findById(id);
    }

    @GetMapping("/tasks/paged")
    public Page<TaskResponseDto> getPagedTasks(Long id, Pageable pageable) {
        return taskService.getPagedTasks(id, pageable);
    }

    @GetMapping("/status/{status}")
    public List<TaskResponseDto> findByStatus(@PathVariable TaskStatus status) {
        return taskService.getTaskFromStatus(status);
    }

    @GetMapping("/assignee/{userId}")
    public List<TaskResponseDto> findByUser(@PathVariable Long userId) {
        return taskService.getTaskFromUser(userId);
    }

    @GetMapping
    public List<TaskResponseDto> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/project/{projectId}")
    public List<TaskResponseDto> getProjectTasks(@PathVariable Long projectId) {
        return taskService.getTasksFromProject(projectId);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    @GetMapping("/stats")
    public TaskStatsDto getStats() {
        return taskService.getStats();
    }

    @PutMapping("/update/{id}")
    public TaskResponseDto updateTask(@Valid @PathVariable Long id,
                                      @RequestBody TaskCreateDto taskCreateDto) {
        return taskService.updateTask(id, taskCreateDto);
    }
}