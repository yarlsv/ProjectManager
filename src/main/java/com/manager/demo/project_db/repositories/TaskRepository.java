package com.manager.demo.project_db.repositories;

import com.manager.demo.project_db.entities.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TaskRepository extends CrudRepository<Task, UUID> {
}
