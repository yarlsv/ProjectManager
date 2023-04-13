package com.manager.demo.project_impl.mapper;

import com.manager.demo.project_api.config.MapperConfig;
import com.manager.demo.project_api.dto.CreateTaskDto;
import com.manager.demo.project_api.dto.TaskDto;
import com.manager.demo.project_db.entities.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class)
public interface TaskMapper {

    @Mapping(target = "projectId", source = "projectId")
    Task toTask(CreateTaskDto createTaskDto);

    @Mapping(target = "taskStatus", source = "status")
    @Mapping(target = "projectId", source = "projectId")
    TaskDto toTaskDto(Task task);
}
