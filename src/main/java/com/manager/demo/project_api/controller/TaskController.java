package com.manager.demo.project_api.controller;

import com.manager.demo.project_api.dto.CreateTaskDto;
import com.manager.demo.project_api.dto.TaskDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Task Controller", description = "Work with Task")
@RequestMapping(value = "/api/v1/task")
@Validated
public interface TaskController {

    @Operation(summary = "Create new task",
    description = "Create new task")
    @PostMapping
    TaskDto createTask(CreateTaskDto createTaskDto);
}
