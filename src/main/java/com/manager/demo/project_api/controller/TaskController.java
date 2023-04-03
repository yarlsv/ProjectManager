package com.manager.demo.project_api.controller;

import com.manager.demo.project_api.dto.ChangeTaskDto;
import com.manager.demo.project_api.dto.CreateTaskDto;
import com.manager.demo.project_api.dto.TaskDto;
import com.manager.demo.project_db.entities.TaskStatus;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Tag(name = "Task Controller", description = "Work with Task")
@RequestMapping(value = "/api/v1/task")
@Validated
public interface TaskController {

    @Operation(summary = "Create new task",
        description = "Create new task")
    @PostMapping
    TaskDto createTask(CreateTaskDto createTaskDto);

    @Operation(summary = "Delete a task",
        description = "Delete a task by id")
    @DeleteMapping
    void deleteTask(UUID taskId);

    @Operation(summary = "Get task by id")
    @GetMapping
    TaskDto getTaskById(UUID taskId);

    @Operation(summary = "Get task by task statuses")
    @GetMapping("/getByStatus")
    List<TaskDto> getTasksByStatus(List<TaskStatus> statusList);

    @Operation(summary = "Get all tasks by project id")
    @GetMapping("/getAllTasksByProjectId")
    List<TaskDto> getAllTaskByProjectId(UUID projectId);

    @Operation(summary = "Get all task")
    @GetMapping("/all")
    List<TaskDto> getAllTasks();

    @Operation(summary = "Get task by project id and task statuses")
    @GetMapping("/getTasksByIdAndStatuses")
    List<TaskDto> getAllTaskByProjectIdAndTaskStatuses(UUID projectId, List<TaskStatus> status);

    @Operation(summary = "Change task status by id")
    @PatchMapping("/{id}/changeStatus")
    TaskDto changeTaskStatus(UUID taskId, TaskStatus status);

    @Operation(summary = "Change task by id")
    @PutMapping
    TaskDto changeTaskById(ChangeTaskDto changeTaskDto);
}
