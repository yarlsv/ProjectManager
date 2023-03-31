package com.manager.demo.project_api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class AuthenticationRequestDto {
    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;
}
