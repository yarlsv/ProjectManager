package com.manager.demo.project_api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import static com.manager.demo.project_api.utility.OpenApiConstants.*;

@Data
public class SignupRequestDto {

    @Schema(example = EXAMPLE_EMAIL)
    @NotNull(message = "Email can't be null.")
    private String email;

    @Schema(example = EXAMPLE_PASSWORD)
    @NotNull(message = "Passport can't be null.")
    private String password;

    @Schema(example = EXAMPLE_NAME)
    @NotNull(message = "First name can't be null.")
    private String firstName;

    @Schema(example = EXAMPLE_LASTNAME)
    @NotNull(message = "Last name can't be null.")
    private String lastName;
}
