package com.manager.demo.project_api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

import static com.manager.demo.project_api.utility.OpenApiConstants.*;

@Data
public class CreateTaskDto {

    @Schema(example = EXAMPLE_TASK_NAME)
    @NotNull(message = "Name can't be null.")
    private String name;
    @Schema(example = EXAMPLE_DESCRIPTION)
    private String information;
    @Schema(example = EXAMPLE_UUID)
    private UUID projectId;
}
