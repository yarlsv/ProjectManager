package com.manager.demo.project_impl.service;

import com.manager.demo.project_api.dto.ChangeProjectDto;
import com.manager.demo.project_api.dto.CreateProjectDto;
import com.manager.demo.project_api.dto.ProjectDto;
import com.manager.demo.project_api.service.ProjectService;
import com.manager.demo.project_db.entities.Project;
import com.manager.demo.project_db.repositories.ProjectRepository;
import com.manager.demo.project_impl.exception.ProjectNotFoundException;
import com.manager.demo.project_impl.exception.TaskNotFoundException;
import com.manager.demo.project_impl.mapper.ProjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    @Override
    @Transactional
    public ProjectDto createProject(CreateProjectDto createProjectDto) {
        Project project = projectMapper.toProject(createProjectDto);
        project.setCreationDate(LocalDate.now());

        log.info("Project was successfully created");
        projectRepository.save(project);

        return projectMapper.toProjectDto(project);
    }

    @Override
    @Transactional
    public void changeProject(ChangeProjectDto changeProjectDto) {
        Project project = projectRepository.findById(changeProjectDto.getId())
                .orElseThrow(() -> new ProjectNotFoundException(changeProjectDto.getId()));

        project.setName(changeProjectDto.getName());
        project.setDescription(changeProjectDto.getDescription());

        log.info("The project with id {} was changed", changeProjectDto.getId());
    }

    @Override
    public ProjectDto getProjectById(UUID projectId) {
        return projectMapper.toProjectDto(projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectNotFoundException(projectId)));
    }

    @Override
    public ProjectDto getProjectByTaskId(UUID taskId) {
        return projectMapper.toProjectDto(projectRepository.findByTaskId(taskId)
                .orElseThrow(() -> new TaskNotFoundException(taskId)));
    }

    @Override
    public List<ProjectDto> getAllProjects() {
        List<Project> projectList = (List<Project>) projectRepository.findAll();

        log.info("Getting all project was successful");
        return projectList.stream()
                .map(projectMapper::toProjectDto)
                .toList();
    }
}
