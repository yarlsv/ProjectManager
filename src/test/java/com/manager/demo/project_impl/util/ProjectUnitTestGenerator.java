package com.manager.demo.project_impl.util;

import com.manager.demo.project_api.dto.CreateProjectDto;
import com.manager.demo.project_api.dto.ProjectDto;
import com.manager.demo.project_db.entities.Project;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProjectUnitTestGenerator {

    private static final String PROJECT_UUID = "c371a6f0-2262-4892-92a2-5d2e172c8c06";
    private static final String PROJECT_NAME = "Project1";
    private static final String PROJECT_DESCRIPTION = "Description";

    public static CreateProjectDto createCreateProjectDto() {
        CreateProjectDto dto = new CreateProjectDto();
        dto.setName("Project1");
        dto.setDescription(PROJECT_DESCRIPTION);
        return dto;
    }

    public static Project createProject() {
        Project project = new Project();
        project.setId(UUID.fromString(PROJECT_UUID));
        project.setCreationDate(LocalDate.now());
        project.setName(PROJECT_NAME);
        project.setDescription(PROJECT_DESCRIPTION);

        return project;
    }

    public static ProjectDto createProjectDto() {
        ProjectDto projectDto = new ProjectDto();
        projectDto.setId(UUID.fromString(PROJECT_UUID));
        projectDto.setName(PROJECT_NAME);
        projectDto.setDescription(PROJECT_DESCRIPTION);
        projectDto.setCreationDate(LocalDate.now());

        return projectDto;
    }
}
