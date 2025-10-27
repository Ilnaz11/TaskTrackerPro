package ru.baymukhametov.TaskTrackerPro.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.baymukhametov.TaskTrackerPro.Entity.Project;
import ru.baymukhametov.TaskTrackerPro.Repository.ProjectRepository;
import ru.baymukhametov.TaskTrackerPro.dto.ProjectCreateDto;
import ru.baymukhametov.TaskTrackerPro.mapper.ProjectMapper;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProjectServiceImpl implements  ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    @Override
    public ProjectCreateDto createProject(Project project) {
        return projectMapper.toDto(project);
    }

    @Override
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public Optional<ProjectCreateDto> findById(Long id) {
        Optional<Project> projectOptional = projectRepository.findById(id);
        return projectOptional.map(projectMapper::toDto);
    }


    @Override
    public ProjectCreateDto updateProject(Long id, ProjectCreateDto projectCreateDto) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found project id: " + id));
        if (projectCreateDto.getManagerId() != null) {
            project.setId(projectCreateDto.getManagerId());
        }
        if (projectCreateDto.getName() != null) {
            project.setName(projectCreateDto.getName());
        }
        if (projectCreateDto.getDescription() != null) {
            project.setDescription(projectCreateDto.getDescription());
        }

        Project updatedProject = projectRepository.save(project);

        return projectMapper.toDto(updatedProject);
    }
}
