package com.manager.demo.project_impl.validation;

import com.manager.demo.project_db.repositories.ProjectRepository;
import com.manager.demo.project_impl.exception.ProjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ProjectIsExistValidator implements ProjectValidator {

    private final ProjectRepository projectRepository;

    @Override
    public void validate(UUID projectId) {
        projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectNotFoundException(projectId));
    }
}
