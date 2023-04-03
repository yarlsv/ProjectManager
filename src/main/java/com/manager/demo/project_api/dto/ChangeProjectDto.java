package com.manager.demo.project_api.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ChangeProjectDto {

    private UUID id;
    private String name;
    private String description;
}
