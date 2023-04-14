package com.manager.demo.project_impl.service;

import com.manager.demo.project_api.dto.CreateProjectDto;
import com.manager.demo.project_api.dto.ProjectDto;
import com.manager.demo.project_api.service.ProjectService;
import com.manager.demo.project_db.repositories.ProjectRepository;
import com.manager.demo.project_impl.mapper.ProjectMapperImpl;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.annotation.ComponentScan;

import static com.manager.demo.project_impl.util.ProjectUnitTestGenerator.createCreateProjectDto;
import static com.manager.demo.project_impl.util.ProjectUnitTestGenerator.createProjectDto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = { ProjectService.class,
                            ProjectMapperImpl.class})
@ComponentScan(lazyInit = true)
@Data
class ProjectServiceImplTest {

    @SpyBean
    ProjectServiceImpl projectService;

    @MockBean
    private ProjectRepository projectRepository;
    private ProjectMapperImpl projectMapper;

    @Test
    void createNewProject_ShouldReturnProjectDto() {
        ProjectDto expected = createProjectDto();
        expected.setId(null);
        CreateProjectDto request = createCreateProjectDto();

        when(projectRepository.save(any())).thenReturn(any());

        assertEquals(expected, projectService.createProject(request));
    }
}
