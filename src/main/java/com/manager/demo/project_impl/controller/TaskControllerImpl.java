package com.manager.demo.project_impl.controller;

import com.manager.demo.project_api.controller.TaskController;
import com.manager.demo.project_api.dto.ChangeTaskDto;
import com.manager.demo.project_api.dto.CreateTaskDto;
import com.manager.demo.project_api.dto.TaskDto;
import com.manager.demo.project_api.service.TaskService;
import com.manager.demo.project_db.entities.TaskStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static com.manager.demo.project_impl.security.SecurityUtil.ADMIN_AND_USER;

@RequiredArgsConstructor
@PreAuthorize(ADMIN_AND_USER)
@RestController
@Slf4j
public class TaskControllerImpl implements TaskController {

    private final TaskService taskService;

    @Override
    public TaskDto createTask(CreateTaskDto createTaskDto) {
        log.info("Creating new task");
        return taskService.createTask(createTaskDto);
    }

    @Override
    public void deleteTask(UUID taskId) {
        log.info("Deleting task: {}", taskId);
        taskService.deleteTask(taskId);
    }

    @Override
    public List<TaskDto> getAllTasks() {
        log.info("Getting all tasks");
        return taskService.getAllTask();
    }

    @Override
    public TaskDto getTaskById(UUID taskId) {
        log.info("Getting task: {}", taskId);
        return taskService.getTaskById(taskId);
    }

    @Override
    public List<TaskDto> getTasksByStatus(List<TaskStatus> statusList) {
        log.info("Getting tasks with statuses: {}", statusList.toString());
        return taskService.getTasksByStatus(statusList);
    }

    @Override
    public List<TaskDto> getAllTaskByProjectId(UUID projectId) {
        log.info("Getting tasks with project id: {}", projectId);
        return taskService.getAllTaskByProjectId(projectId);
    }

    @Override
    public List<TaskDto> getAllTaskByProjectIdAndTaskStatuses(UUID projectId, List<TaskStatus> status) {
        log.info("Getting tasks with project id:{} and statuses: {}", projectId, status.toString());
        return taskService.getAllTaskByProjectIdAndTaskStatuses(projectId, status);
    }

    @Override
    public TaskDto changeTaskStatus(UUID taskId, TaskStatus status) {
        log.info("Changing task's ({}) status to {}", taskId, status);
        return taskService.changeTaskStatus(taskId, status);
    }

    @Override
    public TaskDto changeTaskById(ChangeTaskDto changeTaskDto) {
        log.info("Changing task {}", changeTaskDto.getId());
        return taskService.changeTaskById(changeTaskDto);
    }
}
