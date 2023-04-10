package com.manager.demo.project_impl.exception;

import java.util.UUID;


public class ProjectNotFoundException extends RuntimeException {

    public ProjectNotFoundException(UUID id) {
       super(String.format("Not found a project with id = %s", id));
    }
}
