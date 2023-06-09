package com.manager.demo.project_impl.service;

import com.manager.demo.project_api.dto.ChangeTaskDto;
import com.manager.demo.project_api.dto.CreateTaskDto;
import com.manager.demo.project_api.dto.TaskDto;
import com.manager.demo.project_api.service.TaskService;
import com.manager.demo.project_db.entities.Project;
import com.manager.demo.project_db.entities.Task;
import com.manager.demo.project_db.entities.TaskStatus;
import com.manager.demo.project_db.repositories.ProjectRepository;
import com.manager.demo.project_db.repositories.TaskRepository;
import com.manager.demo.project_impl.exception.ProjectNotFoundException;
import com.manager.demo.project_impl.exception.TaskNotFoundException;
import com.manager.demo.project_impl.mapper.TaskMapper;
import com.manager.demo.project_impl.validation.ProjectValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;
    private final TaskMapper taskMapper;
    private final ProjectValidator projectValidator;

    @Override
    @Transactional
    public TaskDto createTask(CreateTaskDto createTaskDto) {

        if(createTaskDto.getProjectId() != null) {
            projectValidator.validate(createTaskDto.getProjectId());
        }

        Task task = taskMapper.toTask(createTaskDto);
        task.setCreationDate(LocalDate.now());
        task.setStatus(TaskStatus.NEW);
        task.setChangeStatusDate(LocalDate.now());

        Project project = projectRepository.findById(createTaskDto.getProjectId())
                .orElseThrow(() -> new ProjectNotFoundException(createTaskDto.getProjectId()));
        project.getTaskList().add(task);

        projectRepository.save(project);
        taskRepository.save(task);

        log.info("Task was successfully created");
        return taskMapper.toTaskDto(task);
    }

    @Override
    @Transactional
    public void deleteTask(UUID taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException(taskId));
        taskRepository.deleteById(task.getId());

        log.info("The task {} was successfully deleted", taskId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TaskDto> getAllTask() {
        List<Task> taskList = (List<Task>) taskRepository.findAll();

        log.info("Getting all task from DataBase was successful");
        return taskList.stream()
                .map(taskMapper::toTaskDto)
                .toList();
    }

    @Override
    public TaskDto getTaskById(UUID taskId) {
        log.info("Getting task {} from DB was successful", taskId);
        return taskMapper.toTaskDto(
                taskRepository.findById(taskId)
                        .orElseThrow(() -> new TaskNotFoundException(taskId)));
    }

    @Override
    public List<TaskDto> getTasksByStatus(TaskStatus status) {
        List<Task> list = taskRepository.findByStatus(status);

        log.info("Getting a task by status: {} was successful", status.toString());
        return list.stream()
                .map(taskMapper::toTaskDto)
                .toList();
    }

    @Override
    public List<TaskDto> getAllTaskByProjectId(UUID projectId) {
        List<Task> taskList = taskRepository.findByProjectId(projectId);

        log.info("Getting a task with project id = {} was successful", projectId);
        return taskList.stream()
                .map(taskMapper::toTaskDto)
                .toList();
    }

    @Override
    public List<TaskDto> getAllTaskByProjectIdAndTaskStatus(UUID projectId, TaskStatus status) {
        List<Task> taskList = taskRepository.findByProjectIdAndStatus(projectId, status);

        log.info("Getting tasks with project id = {} and statuses = {} was successful", projectId, status.toString());
        return taskList.stream()
                .map(taskMapper::toTaskDto)
                .toList();
    }

    @Override
    @Transactional
    public TaskDto changeTaskStatus(UUID taskId, TaskStatus status) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException(taskId));
        task.setStatus(status);
        task.setChangeStatusDate(LocalDate.now());

        log.info("Changing the task's status with id = {} was successful", taskId);
        return taskMapper.toTaskDto(task);
    }

    @Override
    @Transactional
    public TaskDto changeTaskById(ChangeTaskDto changeTaskDto) {
        Task task = taskRepository.findById(changeTaskDto.getId())
                .orElseThrow(() -> new TaskNotFoundException(changeTaskDto.getId()));
        task.setName(changeTaskDto.getName());
        task.setInformation(changeTaskDto.getInformation());

        if(changeTaskDto.getProjectID() != null) {
            task.setProjectId(projectRepository.findById(changeTaskDto.getProjectID()).get().getId());
        }

        log.info("Changing the task with id = {} was successful", changeTaskDto.getId());
        return taskMapper.toTaskDto(task);
    }
}
