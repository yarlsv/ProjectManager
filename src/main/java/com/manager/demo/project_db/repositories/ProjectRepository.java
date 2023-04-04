package com.manager.demo.project_db.repositories;

import com.manager.demo.project_db.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProjectRepository extends CrudRepository<Project, UUID> {

    @Query(value = "select e from Project e " +
        "join e.taskList c " +
        "where c.id = :taskId")
    Optional<Project> findByTaskId(UUID taskId);

}
