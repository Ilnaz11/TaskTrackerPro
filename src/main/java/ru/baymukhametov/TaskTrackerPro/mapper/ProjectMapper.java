package ru.baymukhametov.TaskTrackerPro.mapper;

import ru.baymukhametov.TaskTrackerPro.Entity.Project;
import ru.baymukhametov.TaskTrackerPro.dto.ProjectCreateDto;

public class ProjectMapper {

    public ProjectCreateDto toDto(Project project) {
        if (project == null) {
            return null;
        }
            ProjectCreateDto projectCreateDto = new ProjectCreateDto();

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
}
