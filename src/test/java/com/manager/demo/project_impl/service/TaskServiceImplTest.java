package com.manager.demo.project_impl.service;

import com.manager.demo.project_api.dto.ChangeTaskDto;
import com.manager.demo.project_api.dto.CreateTaskDto;
import com.manager.demo.project_api.dto.TaskDto;
import com.manager.demo.project_db.entities.Project;
import com.manager.demo.project_db.entities.Task;
import com.manager.demo.project_db.entities.TaskStatus;
import com.manager.demo.project_db.repositories.ProjectRepository;
import com.manager.demo.project_db.repositories.TaskRepository;
import com.manager.demo.project_impl.mapper.TaskMapper;
import com.manager.demo.project_impl.mapper.TaskMapperImpl;
import com.manager.demo.project_impl.validation.ProjectValidator;
import lombok.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import static com.manager.demo.project_impl.util.ProjectUnitTestGenerator.createProject;
import static com.manager.demo.project_impl.util.TaskUnitTestGenerator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = { TaskServiceImpl.class,
                            TaskMapperImpl.class})
@ComponentScan(lazyInit = true)
@Data
public class TaskServiceImplTest {

    @SpyBean
    TaskServiceImpl taskService;

    @MockBean
    private TaskRepository taskRepository;
    @MockBean
    private ProjectRepository projectRepository;
    private TaskMapper taskMapper = new TaskMapperImpl();

    @MockBean
    private ProjectValidator projectValidator;

    private TaskDto expected;

    @BeforeEach
    void init() {
        expected = createTaskDto();
    }

    @Test
    void createTask_ShouldReturnTaskDto() {
        CreateTaskDto request = createCreateTaskDto();
        Project project = createProject();
        project.setTaskList(new ArrayList<>());

        expected.setId(null);

        when(projectRepository.findById(any())).thenReturn(Optional.of(project));
        when(projectRepository.save(any())).thenReturn(project);
        when(taskRepository.save(any())).thenReturn(any());

        assertEquals(expected, taskService.createTask(request));
    }

    @Test
    void changeTaskStatus_ShouldReturnTaskDto() {
        expected.setTaskStatus(TaskStatus.DONE);

        Task task = createTask();

        when(taskRepository.findById(any())).thenReturn(Optional.of(task));

        assertEquals(expected, taskService.changeTaskStatus(UUID.fromString("baca6997-f27b-4fac-ae22-25bb79fcff5c"), TaskStatus.DONE));
    }

    @Test
    void changeTaskById_ShouldReturnTaskDto() {
        expected.setName("Task name2");
        expected.setInformation("Description2");

        Task task = createTask();
        ChangeTaskDto request = createChangeTaskDto();

        Project project = createProject();

        when(taskRepository.findById(any())).thenReturn(Optional.of(task));
        when(projectRepository.findById(any())).thenReturn(Optional.of(project));

        assertEquals(expected, taskService.changeTaskById(request));

    }

}
