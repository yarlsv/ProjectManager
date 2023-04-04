package com.manager.demo.project_impl.controller;

import com.manager.demo.project_api.controller.ProjectController;
import com.manager.demo.project_api.dto.ChangeProjectDto;
import com.manager.demo.project_api.dto.CreateProjectDto;
import com.manager.demo.project_api.dto.ProjectDto;
import com.manager.demo.project_api.service.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static com.manager.demo.project_impl.security.SecurityUtil.ADMIN;
import static com.manager.demo.project_impl.security.SecurityUtil.ADMIN_AND_USER;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ProjectControllerImpl implements ProjectController {

    private final ProjectService projectService;

    @Override
    @PreAuthorize(ADMIN)
    public ProjectDto createProject(CreateProjectDto createProjectDto) {
        log.info("Creating a project {}", createProjectDto.getName());

        return projectService.createProject(createProjectDto);
    }

    @Override
    @PreAuthorize(ADMIN)
    public void changeProject(ChangeProjectDto changeProjectDto) {
        log.info("Changing a project with id = {}", changeProjectDto.getId());

        projectService.changeProject(changeProjectDto);
    }

    @Override
    @PreAuthorize(ADMIN_AND_USER)
    public ProjectDto getProjectById(UUID projectId) {
        log.info("Getting a project with id = {}", projectId);

        return projectService.getProjectById(projectId);
    }

    @Override
    @PreAuthorize(ADMIN_AND_USER)
    public ProjectDto getProjectByTaskId(UUID taskId) {
        log.info("Getting a project with task id = {}", taskId);

        return projectService.getProjectByTaskId(taskId);
    }

    @Override
//    @PreAuthorize(ADMIN_AND_USER)
    public List<ProjectDto> getAllProjects() {
        log.info("Getting all projects");

        return projectService.getAllProjects();
    }
}
