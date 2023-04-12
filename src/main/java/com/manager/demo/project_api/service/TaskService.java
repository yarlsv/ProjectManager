package com.manager.demo.project_api.service;

import com.manager.demo.project_api.dto.ChangeTaskDto;
import com.manager.demo.project_api.dto.CreateTaskDto;
import com.manager.demo.project_api.dto.TaskDto;
import com.manager.demo.project_db.entities.TaskStatus;

import java.util.List;
import java.util.UUID;

public interface TaskService {

    TaskDto createTask(CreateTaskDto createTaskDto);
    void deleteTask(UUID taskId);
    List<TaskDto> getAllTask();

    TaskDto getTaskById(UUID taskId);

    List<TaskDto> getTasksByStatus(TaskStatus status);
    List<TaskDto> getAllTaskByProjectId(UUID projectId);

    List<TaskDto> getAllTaskByProjectIdAndTaskStatus(UUID projectId, TaskStatus status);

    TaskDto changeTaskStatus(UUID taskId, TaskStatus status);

    TaskDto changeTaskById(ChangeTaskDto changeTaskDto);

}
