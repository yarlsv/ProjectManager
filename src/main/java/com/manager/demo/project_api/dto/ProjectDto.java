package com.manager.demo.project_api.dto;

import com.manager.demo.project_db.entities.Task;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static com.manager.demo.project_api.utility.OpenApiConstants.*;

@Data
public class ProjectDto {
    @Schema(example = EXAMPLE_UUID)
    @NotNull(message = "ID can't be null.")
    private UUID id;
    @Schema(example = EXAMPLE_PROJECT_NAME)
    private String name;
    private List<Task> taskList;
    @Schema(example = EXAMPLE_DATE)
    @NotNull(message = "Date can't be null.")
    private LocalDate creationDate;
    @Schema(example = EXAMPLE_DESCRIPTION)
    private String description;
}
