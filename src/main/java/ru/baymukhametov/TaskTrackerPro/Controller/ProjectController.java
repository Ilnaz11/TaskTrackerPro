package ru.baymukhametov.TaskTrackerPro.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.baymukhametov.TaskTrackerPro.Service.ProjectServiceImpl;
import ru.baymukhametov.TaskTrackerPro.dto.ProjectCreateDto;
import ru.baymukhametov.TaskTrackerPro.dto.ProjectResponseDto;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/projects")
public class ProjectController {

    private ProjectServiceImpl projectService;

    @PostMapping
    public ProjectResponseDto createProject(@RequestBody ProjectCreateDto projectCreateDto) {
        return projectService.createProject(projectCreateDto);
    }

    @GetMapping
    public List<ProjectResponseDto> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public Optional<ProjectResponseDto> getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
    }

    @PutMapping("/update/{id}")
    public ProjectResponseDto updateProjectDescription(@PathVariable Long id,
                                                       @RequestBody ProjectCreateDto projectCreateDto) {
        return projectService.updateProjectDescription(id, projectCreateDto);
    }


}