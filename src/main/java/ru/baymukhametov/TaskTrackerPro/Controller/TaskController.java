package ru.baymukhametov.TaskTrackerPro.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.baymukhametov.TaskTrackerPro.Entity.Task;
import ru.baymukhametov.TaskTrackerPro.Entity.TaskStatus;
import ru.baymukhametov.TaskTrackerPro.Service.TaskService;
import ru.baymukhametov.TaskTrackerPro.dto.TaskCreateDto;
import ru.baymukhametov.TaskTrackerPro.dto.TaskResponseDto;
import ru.baymukhametov.TaskTrackerPro.dto.TaskStatusUpdateDto;
import ru.baymukhametov.TaskTrackerPro.mapper.TaskMapper;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("/tasks")
@RestController
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    @PostMapping
    public TaskResponseDto createTask(Task task) {
        return taskMapper.toDto(task);
    }

    @GetMapping("/{id}")
    public Optional<TaskResponseDto> findTaskById(Long id) {
        return taskService.findById(id);
    }

    @GetMapping("/tasks/status/{status}")
    public List<TaskResponseDto> findByStatus(TaskStatus taskStatus) {
        return taskService.getTaskFromStatus(taskStatus);
    }

    @GetMapping("/tasks/assignee/{userId}")
    public List<TaskResponseDto> findByUser(Long id) {
        return taskService.getTaskFromUser(id);
    }

    @GetMapping
    public List<TaskResponseDto> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/tasks/project/{projectId}")
    public List<TaskResponseDto> getProjectTasks(Long id) {
        return taskService.getTasksFromProject(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    @PutMapping("/update/{id}")
    public TaskResponseDto updateTask(@PathVariable Long id,
                                      @RequestBody TaskCreateDto taskCreateDto,
                                      @RequestBody TaskStatusUpdateDto taskStatusUpdateDto) {
        return taskService.updateTask(id, taskCreateDto, taskStatusUpdateDto);
    }

}