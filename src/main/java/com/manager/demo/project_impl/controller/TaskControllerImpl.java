package com.manager.demo.project_impl.controller;

import com.manager.demo.project_api.controller.TaskController;
import com.manager.demo.project_api.dto.CreateTaskDto;
import com.manager.demo.project_api.dto.TaskDto;
import com.manager.demo.project_api.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Slf4j
public class TaskControllerImpl implements TaskController {

    private final TaskService taskService;

    @Override
    public TaskDto createTask(CreateTaskDto createTaskDto) {
        log.info("Creating new task");
        return taskService.createTask(createTaskDto);
    }
}
