package com.manager.demo.project_impl.service;

import com.manager.demo.project_api.dto.CreateTaskDto;
import com.manager.demo.project_api.service.TaskService;
import com.manager.demo.project_db.entities.Task;
import com.manager.demo.project_db.entities.TaskStatus;
import com.manager.demo.project_db.repositories.TaskRepository;
import com.manager.demo.project_impl.mapper.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Override
    @Transactional
    public void createTask(CreateTaskDto createTaskDto) {

        Task task = taskMapper.toTask(createTaskDto);
        task.setCreationDate(LocalDate.now());
        task.setStatus(TaskStatus.NEW);
        task.setChangeStatusDate(null);

        taskRepository.save(task);
    }
}
