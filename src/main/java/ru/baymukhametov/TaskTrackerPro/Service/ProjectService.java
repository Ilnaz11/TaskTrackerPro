package ru.baymukhametov.TaskTrackerPro.Service;

import org.springframework.stereotype.Service;
import ru.baymukhametov.TaskTrackerPro.Entity.Project;
import ru.baymukhametov.TaskTrackerPro.dto.ProjectCreateDto;
import ru.baymukhametov.TaskTrackerPro.dto.ProjectResponseDto;

import java.util.List;
import java.util.Optional;

@Service
public interface ProjectService {

    ProjectResponseDto createProject(ProjectCreateDto projectCreateDto);
    List<ProjectResponseDto> getAllProjects();
    ProjectResponseDto updateProjectDescription(Long id, ProjectCreateDto projectCreateDto);
    void deleteProject(Long id);
    Optional<ProjectResponseDto> getProjectById(Long id);
    ProjectResponseDto updateProject(Long id, ProjectCreateDto projectCreateDto);
}
//o	создания и удаления сущностей;
//o	поиска по ID;
//o	обновления данных.
