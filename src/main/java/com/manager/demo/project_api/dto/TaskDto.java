package com.manager.demo.project_api.dto;

import com.manager.demo.project_db.entities.TaskStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class TaskDto {

    @NotNull(message = "ID can't be null.")
    private UUID id;
    private String name;
    private TaskStatus taskStatus;
    private LocalDate creationDate;
    private LocalDate changeStatusDate;
    private String information;
    private UUID projectId;
}
