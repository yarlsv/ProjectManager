package com.manager.demo.project_impl.util;

import com.manager.demo.project_api.dto.CreateProjectDto;
import com.manager.demo.project_db.entities.Project;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProjectUnitTestGenerator {

    public static CreateProjectDto createProjectDto() {
        CreateProjectDto dto = new CreateProjectDto();
        dto.setName("Project1");
        dto.setDescription("Description");
        return dto;
    }

    public static Project createProject() {
        Project project = new Project();
        project.setId(UUID.randomUUID());
        project.setCreationDate(LocalDate.now());
        project.setName("Project1");
        project.setDescription("Description");

        return project;
    }
}
