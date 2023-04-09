package com.manager.demo.project_api.controller;

import com.manager.demo.project_api.dto.ChangeProjectDto;
import com.manager.demo.project_api.dto.CreateProjectDto;
import com.manager.demo.project_api.dto.ProjectDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

import static com.manager.demo.project_impl.security.SecurityUtil.ADMIN;
import static com.manager.demo.project_impl.security.SecurityUtil.ADMIN_AND_USER;

@Tag(name = "Project Controller", description = "Work with Project")
@RequestMapping(value = "api/v1/project")
@SecurityRequirement(name = "Bearer Authentication")
@Validated
public interface ProjectController {


    @PostMapping
    @Operation(summary = "Create new project",
        description = "create new project")
    @PreAuthorize(ADMIN)
    ProjectDto createProject(@Validated @RequestBody CreateProjectDto createProjectDto);
    @PutMapping
    @Operation(summary = "Change a project",
        description = "change a project")
    void changeProject(@Validated @RequestBody ChangeProjectDto changeProjectDto);

    @GetMapping("/{id}")
    @Operation(summary = "Get a project by id",
        description = "get a project by project id")
    ProjectDto getProjectById(UUID projectId);
    @GetMapping("/getByTaskId")
    @Operation(summary = "Get a project by task id",
            description = "Get a project by task id")
    ProjectDto getProjectByTaskId(UUID taskId);

    @GetMapping("/allProjects")
    @Operation(summary = "Get all projects",
        description = "Get all projects")
    @PreAuthorize(ADMIN_AND_USER)
    List<ProjectDto> getAllProjects();

}
