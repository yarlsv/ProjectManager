package com.manager.demo.project_db.repositories;

import com.manager.demo.project_db.entities.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ProjectRepository extends CrudRepository<Project, UUID> {

}
