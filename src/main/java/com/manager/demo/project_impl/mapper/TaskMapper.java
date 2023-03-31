package com.manager.demo.project_impl.mapper;

import com.manager.demo.project_api.config.MapperConfig;
import com.manager.demo.project_api.dto.CreateTaskDto;
import com.manager.demo.project_api.dto.TaskDto;
import com.manager.demo.project_db.entities.Task;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface TaskMapper {

    Task toTask(CreateTaskDto createTaskDto);
    TaskDto toTaskDto(Task task);
}
