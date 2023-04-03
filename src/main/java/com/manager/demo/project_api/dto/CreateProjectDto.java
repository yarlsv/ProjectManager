package com.manager.demo.project_api.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateProjectDto {

    private String name;
    private LocalDate creationDate;
    private String description;
}
