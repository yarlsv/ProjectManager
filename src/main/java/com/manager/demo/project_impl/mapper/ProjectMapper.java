package com.manager.demo.project_impl.mapper;

import com.manager.demo.project_api.config.MapperConfig;
import com.manager.demo.project_api.dto.CreateProjectDto;
import com.manager.demo.project_api.dto.ProjectDto;
import com.manager.demo.project_db.entities.Project;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface ProjectMapper {

    Project toProject(CreateProjectDto createProjectDto);
    ProjectDto toProjectDto(Project project);
}
