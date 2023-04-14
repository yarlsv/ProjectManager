package com.manager.demo.project_impl.util;

import com.manager.demo.project_api.dto.ChangeTaskDto;
import com.manager.demo.project_api.dto.CreateTaskDto;
import com.manager.demo.project_api.dto.TaskDto;
import com.manager.demo.project_db.entities.Task;
import com.manager.demo.project_db.entities.TaskStatus;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TaskUnitTestGenerator {

    private static final String TASK_NAME = "Task name";
    private static final String TASK_INFORMATION = "Task information";
    private static final String TASK_UUID= "baca6997-f27b-4fac-ae22-25bb79fcff5c";
    private static final String PROJECT_UUID= "c371a6f0-2262-4892-92a2-5d2e172c8c06";

    public static CreateTaskDto createCreateTaskDto() {
        CreateTaskDto createTaskDto = new CreateTaskDto();
        createTaskDto.setName(TASK_NAME);
        createTaskDto.setInformation(TASK_INFORMATION);
        createTaskDto.setProjectId(UUID.fromString(PROJECT_UUID));

        return createTaskDto;
    }

    public static Task createTask() {
        Task task = new Task();
        task.setId(UUID.fromString(TASK_UUID));
        task.setName(TASK_NAME);
        task.setStatus(TaskStatus.NEW);
        task.setCreationDate(LocalDate.now());
        task.setChangeStatusDate(LocalDate.now());
        task.setInformation(TASK_INFORMATION);
        task.setProjectId(UUID.fromString(PROJECT_UUID));

        return task;
    }

    public static TaskDto createTaskDto() {
        TaskDto taskDto = new TaskDto();
        taskDto.setId(UUID.fromString(TASK_UUID));
        taskDto.setName(TASK_NAME);
        taskDto.setTaskStatus(TaskStatus.NEW);
        taskDto.setCreationDate(LocalDate.now());
        taskDto.setChangeStatusDate(LocalDate.now());
        taskDto.setInformation(TASK_INFORMATION);
        taskDto.setProjectId(UUID.fromString(PROJECT_UUID));

        return taskDto;
    }

    public static ChangeTaskDto createChangeTaskDto() {
        ChangeTaskDto changeTaskDto = new ChangeTaskDto();
        changeTaskDto.setId(UUID.fromString(TASK_UUID));
        changeTaskDto.setInformation("Description2");
        changeTaskDto.setName("Task name2");
        changeTaskDto.setProjectID(UUID.fromString(PROJECT_UUID));

        return changeTaskDto;
    }
}
