package ru.baymukhametov.TaskTrackerPro.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.baymukhametov.TaskTrackerPro.Entity.Project;
import ru.baymukhametov.TaskTrackerPro.Repository.ProjectRepository;
import ru.baymukhametov.TaskTrackerPro.dto.ProjectCreateDto;
import ru.baymukhametov.TaskTrackerPro.dto.ProjectResponseDto;
import ru.baymukhametov.TaskTrackerPro.mapper.ProjectMapper;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProjectServiceImpl implements  ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    @Override
    public ProjectResponseDto createProject(ProjectCreateDto project) {
        Long manager_id = project.getManagerId();
        Project project2 = projectRepository.findById(manager_id)
                .orElseThrow(() -> new RuntimeException("Not found Manager id: " + manager_id));

        Project project1 = new Project();
        project1.setName(project.getName());
        project1.setDescription(project.getDescription());
        project1.setId(project.getManagerId());

        Project savedProject = projectRepository.save(project1);
        return projectMapper.toDto(savedProject);
    }

    @Override
    public List<ProjectResponseDto> getAllProjects() {
        List<Project> projects = projectRepository.findAll();
        return projectMapper.toDtoList(projects);
    }

    @Override
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public Optional<ProjectResponseDto> getProjectById(Long id) {
        Optional<Project> projectOptional = projectRepository.findById(id);
        return projectOptional.map(projectMapper::toDto);
    }


    @Override
    public ProjectResponseDto updateProject(Long id, ProjectCreateDto projectCreateDto) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found project id: " + id));
        if (projectCreateDto.getName() != null) {
            project.setName(projectCreateDto.getName());
        }
        if (projectCreateDto.getDescription() != null) {
            project.setDescription(projectCreateDto.getDescription());
        }

        Project updatedProject = projectRepository.save(project);

        return projectMapper.toDto(updatedProject);
    }

    @Override
    public ProjectResponseDto updateProjectDescription(Long id, ProjectCreateDto projectCreateDto) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found project id: " + id));
        if (projectCreateDto.getDescription() != null) {
            project.setDescription(projectCreateDto.getDescription());
        }

        Project updatedProject = projectRepository.save(project);

        return projectMapper.toDto(updatedProject);
    }
}
