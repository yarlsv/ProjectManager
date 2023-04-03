package com.manager.demo.project_api.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ChangeTaskDto {
    private UUID id;
    private String name;
    private String information;
}
