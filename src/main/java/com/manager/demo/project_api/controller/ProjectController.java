package com.manager.demo.project_api.controller;

import com.manager.demo.project_api.dto.ChangeProjectDto;
import com.manager.demo.project_api.dto.CreateProjectDto;
import com.manager.demo.project_api.dto.ProjectDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Tag(name = "Project Controller", description = "Work with Project")
@RequestMapping(value = "api/v1/project")
@Validated
public interface ProjectController {


    @PostMapping
    @Operation(summary = "Create new project",
        description = "create new project")
    ProjectDto createProject(CreateProjectDto createProjectDto);
    @PutMapping
    @Operation(summary = "Change a project",
        description = "change a project")
    ProjectDto changeProject(ChangeProjectDto changeProjectDto);

    @GetMapping("/{id}")
    @Operation(summary = "Get a project by id",
        description = "get a project by project id")
    ProjectDto getProjectById(UUID projectId);
    @GetMapping("/getByTaskId")
    @Operation(summary = "Get a project by task id",
            description = "Get a project by task id")
    ProjectDto getProjectByTaskId(UUID taskId);

}
