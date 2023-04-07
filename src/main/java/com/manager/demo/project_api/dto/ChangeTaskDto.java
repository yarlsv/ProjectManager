package com.manager.demo.project_api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

import static com.manager.demo.project_api.utility.OpenApiConstants.*;

@Data
public class ChangeTaskDto {

    @Schema(example = EXAMPLE_UUID)
    private UUID id;

    @Schema(example = EXAMPLE_TASK_NAME)
    private String name;

    @Schema(example = EXAMPLE_DESCRIPTION)
    private String information;

    @Schema(example = EXAMPLE_UUID)
    private UUID projectID;
}
