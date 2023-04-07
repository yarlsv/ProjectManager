package com.manager.demo.project_api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import static com.manager.demo.project_api.utility.OpenApiConstants.EXAMPLE_DESCRIPTION;
import static com.manager.demo.project_api.utility.OpenApiConstants.EXAMPLE_TASK_NAME;

@Data
public class CreateProjectDto {

    @Schema(example = EXAMPLE_TASK_NAME)
    private String name;

    @Schema(example = EXAMPLE_DESCRIPTION)
    private String description;
}
