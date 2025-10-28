package ru.baymukhametov.TaskTrackerPro.mapper;

import ru.baymukhametov.TaskTrackerPro.Entity.Project;
import ru.baymukhametov.TaskTrackerPro.dto.ProjectCreateDto;
import ru.baymukhametov.TaskTrackerPro.dto.ProjectResponseDto;

import java.util.List;

public class ProjectMapper {

    public ProjectResponseDto toDto(Project project) {
        if (project == null) {
            return null;
        }
            ProjectResponseDto projectCreateDto = new ProjectResponseDto();

            projectCreateDto.setName(project.getName());
            projectCreateDto.setDescription(project.getDescription());
            projectCreateDto.setManagerId(project.getId());

            return projectCreateDto;
    }

    public Project toEntity(ProjectCreateDto projectCreateDto) {
        if (projectCreateDto != null) {
            return null;
        }
        Project project = new Project();

        project.setName(projectCreateDto.getName());
        project.setDescription(projectCreateDto.getDescription());
        project.setId(projectCreateDto.getManagerId());

        return project;
    }

    public List<ProjectResponseDto> toDtoList(List<Project> projects) {
        if (projects == null) {
            return null;
        }
        return projects
                .stream()
                .map(this::toDto)
                .toList();
    }
}
