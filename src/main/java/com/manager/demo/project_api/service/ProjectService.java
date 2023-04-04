package com.manager.demo.project_api.service;

import com.manager.demo.project_api.dto.ChangeProjectDto;
import com.manager.demo.project_api.dto.CreateProjectDto;
import com.manager.demo.project_api.dto.ProjectDto;

import java.util.List;
import java.util.UUID;

public interface ProjectService {

    ProjectDto createProject(CreateProjectDto createProjectDto);
    void changeProject(ChangeProjectDto changeProjectDto);
    ProjectDto getProjectById(UUID projectId);
    ProjectDto getProjectByTaskId(UUID taskId);
    List<ProjectDto> getAllProjects();
}
