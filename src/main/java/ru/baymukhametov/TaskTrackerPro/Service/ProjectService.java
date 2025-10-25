package ru.baymukhametov.TaskTrackerPro.Service;

import org.springframework.stereotype.Service;
import ru.baymukhametov.TaskTrackerPro.Entity.Project;

import java.util.Optional;

@Service
public interface ProjectService {

    Project createProject(Project project);
    void deleteProject(Long id);
    Optional<Project> findById(Long id);
    Project updateProject();
}
//o	создания и удаления сущностей;
//o	поиска по ID;
//o	обновления данных.
