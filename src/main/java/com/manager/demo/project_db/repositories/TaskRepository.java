package com.manager.demo.project_db.repositories;

import com.manager.demo.project_db.entities.Task;
import com.manager.demo.project_db.entities.TaskStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface TaskRepository extends CrudRepository<Task, UUID> {

    @Query(value = "select t from Task t " +
        "where t.status IN (:statuses)")
    List<Task> findByStatuses(List<TaskStatus> statuses);

    List<Task> findByProjectId(UUID id);

    @Query(value = "select t from Task t " +
        "where t.projectId = :projectId " +
        "and t.status in (:statuses)")
    List<Task> findByProjectIdAndStatuses(UUID projectId, List<TaskStatus> statuses);
}
