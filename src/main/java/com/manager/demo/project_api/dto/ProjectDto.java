package com.manager.demo.project_api.dto;

import com.manager.demo.project_db.entities.Task;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class ProjectDto {
    private UUID id;
    private String name;
    private List<Task> taskList;
    private LocalDate creationDate;
    private String description;
}
