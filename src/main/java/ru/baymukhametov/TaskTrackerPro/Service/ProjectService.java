package ru.baymukhametov.TaskTrackerPro.Service;

import ru.baymukhametov.TaskTrackerPro.dto.ProjectCreateDto;
import ru.baymukhametov.TaskTrackerPro.dto.ProjectResponseDto;

import java.util.List;
import java.util.Optional;

public interface ProjectService {

    ProjectResponseDto createProject(ProjectCreateDto projectCreateDto);
    List<ProjectResponseDto> getAllProjects();
    ProjectResponseDto updateProjectDescription(Long id, ProjectCreateDto projectCreateDto);
    void deleteProject(Long id);
    Optional<ProjectResponseDto> getProjectById(Long id);
    ProjectResponseDto updateProject(Long id, ProjectCreateDto projectCreateDto);
}
