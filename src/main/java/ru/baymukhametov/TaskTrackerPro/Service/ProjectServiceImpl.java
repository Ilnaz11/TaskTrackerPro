package ru.baymukhametov.TaskTrackerPro.Service;


import org.springframework.stereotype.Service;
import ru.baymukhametov.TaskTrackerPro.Entity.Project;
import ru.baymukhametov.TaskTrackerPro.Entity.User;
import ru.baymukhametov.TaskTrackerPro.Repository.ProjectRepository;
import ru.baymukhametov.TaskTrackerPro.Repository.UserRepository;
import ru.baymukhametov.TaskTrackerPro.dto.ProjectCreateDto;
import ru.baymukhametov.TaskTrackerPro.dto.ProjectResponseDto;
import ru.baymukhametov.TaskTrackerPro.mapper.ProjectMapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements  ProjectService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final ProjectMapper projectMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, UserRepository userRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
        this.projectMapper = projectMapper;
    }


    @Override
    public ProjectResponseDto createProject(ProjectCreateDto project) {
        Long manager_id = project.getManagerId();
        User manager = userRepository.findById(manager_id)
                .orElseThrow(() -> new RuntimeException("Not found Manager id: " + manager_id));

        Project project1 = new Project();
        project1.setName(project.getName());
        project1.setDescription(project.getDescription());
        project1.setManager(manager);
        project1.setCreatedAt(project1.getCreatedAt());

        Project savedProject = projectRepository.save(project1);

        updateProject(savedProject.getId(), project);


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

        project.setCreatedAt(LocalDateTime.now());

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
