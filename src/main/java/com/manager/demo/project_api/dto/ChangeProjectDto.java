package com.manager.demo.project_api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

import static com.manager.demo.project_api.utility.OpenApiConstants.*;

@Data
public class ChangeProjectDto {

    @Schema(example = EXAMPLE_UUID)
    @NotNull(message = "ID can't be null.")
    private UUID id;

    @Schema(example = EXAMPLE_PROJECT_NAME)
    private String name;

    @Schema(example = EXAMPLE_DESCRIPTION)
    private String description;
}
