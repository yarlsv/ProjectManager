package com.manager.demo.project_api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import static com.manager.demo.project_api.utility.OpenApiConstants.*;

@Data
public class SignupRequestDto {

    @Schema(example = EXAMPLE_EMAIL)
    private String email;

    @Schema(example = EXAMPLE_PASSWORD)
    private String password;

    @Schema(example = EXAMPLE_NAME)
    private String firstName;

    @Schema(example = EXAMPLE_LASTNAME)
    private String lastName;
}
