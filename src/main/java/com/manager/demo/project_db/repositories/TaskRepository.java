package com.manager.demo.project_db.repositories;

import com.manager.demo.project_db.entities.Task;
import com.manager.demo.project_db.entities.TaskStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface TaskRepository extends CrudRepository<Task, UUID> {

    @Query(value = "select t from Task t " +
        "where t.status = :status")
    List<Task> findByStatus(TaskStatus status);

    List<Task> findByProjectId(UUID id);

    @Query(value = "select t from Task t " +
        "where t.projectId = :projectId " +
        "and t.status = :status")
    List<Task> findByProjectIdAndStatus(UUID projectId, TaskStatus status);
}
