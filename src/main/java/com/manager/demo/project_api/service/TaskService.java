package com.manager.demo.project_api.service;

import com.manager.demo.project_api.dto.CreateTaskDto;

public interface TaskService {

    void createTask(CreateTaskDto createTaskDto);
}
