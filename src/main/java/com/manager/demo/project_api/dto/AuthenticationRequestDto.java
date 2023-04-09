package com.manager.demo.project_api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import static com.manager.demo.project_api.utility.OpenApiConstants.EXAMPLE_EMAIL;
import static com.manager.demo.project_api.utility.OpenApiConstants.EXAMPLE_PASSWORD;

@Data
@JsonIgnoreProperties
public class AuthenticationRequestDto {

    @JsonProperty("email")
    @Schema(example = EXAMPLE_EMAIL, defaultValue = EXAMPLE_EMAIL)
    @NotNull(message = "email can't be null")
    private String email;

    @JsonProperty("password")
    @Schema(example = EXAMPLE_PASSWORD, defaultValue = EXAMPLE_PASSWORD)
    @NotNull(message = "Passport can't be null.")
    private String password;
}
