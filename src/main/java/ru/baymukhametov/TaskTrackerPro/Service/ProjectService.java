package ru.baymukhametov.TaskTrackerPro.Service;

import org.springframework.stereotype.Service;
import ru.baymukhametov.TaskTrackerPro.Entity.Project;
import ru.baymukhametov.TaskTrackerPro.dto.ProjectCreateDto;

import java.util.Optional;

@Service
public interface ProjectService {

    ProjectCreateDto createProject(Project project);
    void deleteProject(Long id);
    Optional<ProjectCreateDto> findById(Long id);
    ProjectCreateDto updateProject(Long id, ProjectCreateDto projectCreateDto);
}
//o	создания и удаления сущностей;
//o	поиска по ID;
//o	обновления данных.
