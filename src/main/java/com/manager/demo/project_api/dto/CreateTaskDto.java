package com.manager.demo.project_api.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class CreateTaskDto {

    private String name;
    private String information;
    private UUID projectId;
}
