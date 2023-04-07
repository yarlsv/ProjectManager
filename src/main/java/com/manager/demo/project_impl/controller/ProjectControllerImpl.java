package com.manager.demo.project_impl.controller;

import com.manager.demo.project_api.controller.ProjectController;
import com.manager.demo.project_api.dto.ChangeProjectDto;
import com.manager.demo.project_api.dto.CreateProjectDto;
import com.manager.demo.project_api.dto.ProjectDto;
import com.manager.demo.project_api.service.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ProjectControllerImpl implements ProjectController {

    private final ProjectService projectService;

    @Override
    public ProjectDto createProject(CreateProjectDto createProjectDto) {
        log.info("Creating a project {}", createProjectDto.getName());

        return projectService.createProject(createProjectDto);
    }

    @Override
    public void changeProject(ChangeProjectDto changeProjectDto) {
        log.info("Changing a project with id = {}", changeProjectDto.getId());

        projectService.changeProject(changeProjectDto);
    }

    @Override
    public ProjectDto getProjectById(UUID projectId) {
        log.info("Getting a project with id = {}", projectId);

        return projectService.getProjectById(projectId);
    }

    @Override
    public ProjectDto getProjectByTaskId(UUID taskId) {
        log.info("Getting a project with task id = {}", taskId);

        return projectService.getProjectByTaskId(taskId);
    }

    @Override
    public List<ProjectDto> getAllProjects() {
        log.info("Getting all projects");

        return projectService.getAllProjects();
    }
}
