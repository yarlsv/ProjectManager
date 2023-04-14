package com.manager.demo.project_impl.mappers;

import com.manager.demo.project_api.dto.CreateProjectDto;
import com.manager.demo.project_db.entities.Project;
import com.manager.demo.project_impl.mapper.ProjectMapper;
import com.manager.demo.project_impl.mapper.ProjectMapperImpl;
import org.junit.jupiter.api.Test;

import static com.manager.demo.project_impl.util.ProjectUnitTestGenerator.createProject;
import static com.manager.demo.project_impl.util.ProjectUnitTestGenerator.createCreateProjectDto;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProjectMapperTest {

    private final ProjectMapper projectMapper = new ProjectMapperImpl();

    @Test
    void whenToProject_andOk() {
        CreateProjectDto createProjectDto = createCreateProjectDto();
        var result = projectMapper.toProject(createProjectDto);

        assertEquals(result.getName(), createProjectDto.getName());
        assertEquals(result.getDescription(), createProjectDto.getDescription());
    }

    @Test
    void whenToProjectDto_andOk() {
        Project project = createProject();
        var result = projectMapper.toProjectDto(project);

        assertEquals(result.getName(), project.getName());
        assertEquals(result.getDescription(), project.getDescription());
    }
}
