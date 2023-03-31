package com.manager.demo.project_api.service;

import com.manager.demo.project_api.dto.CreateTaskDto;
import com.manager.demo.project_api.dto.TaskDto;

public interface TaskService {

    TaskDto createTask(CreateTaskDto createTaskDto);
}
