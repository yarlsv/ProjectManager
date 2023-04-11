package com.manager.demo.project_impl.mappers;

import com.manager.demo.project_api.dto.CreateTaskDto;
import com.manager.demo.project_db.entities.Task;
import com.manager.demo.project_impl.mapper.TaskMapper;
import com.manager.demo.project_impl.mapper.TaskMapperImpl;
import org.junit.jupiter.api.Test;

import static com.manager.demo.project_impl.util.TaskUnitTestGenerator.createTask;
import static com.manager.demo.project_impl.util.TaskUnitTestGenerator.createTaskDto;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskMapperTest {

    private final TaskMapper taskMapper = new TaskMapperImpl();

    @Test
    void whenToTask_andOk() {
        CreateTaskDto createTaskDto = createTaskDto();
        var result = taskMapper.toTask(createTaskDto);

        assertEquals(result.getName(), createTaskDto.getName());
        assertEquals(result.getInformation(), createTaskDto.getInformation());
        assertEquals(result.getProjectId(), createTaskDto.getProjectId());
    }

    @Test
    void whenToTaskDto_andOk() {
        Task task = createTask();
        var result = taskMapper.toTaskDto(task);

        assertEquals(result.getId(), task.getId());
        assertEquals(result.getName(), task.getName());
        assertEquals(result.getTaskStatus(), task.getStatus());
        assertEquals(result.getCreationDate(), task.getCreationDate());
        assertEquals(result.getChangeStatusDate(), task.getChangeStatusDate()
        );
        assertEquals(result.getInformation(), task.getInformation());
        assertEquals(result.getProjectId(), task.getProjectId());
    }
}
