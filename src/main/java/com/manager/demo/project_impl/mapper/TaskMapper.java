package com.manager.demo.project_impl.mapper;

import com.manager.demo.project_api.dto.CreateTaskDto;
import com.manager.demo.project_db.entities.Task;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;

@Mapper(config = MapperConfig.class)
public interface TaskMapper {

    Task toTask(CreateTaskDto createTaskDto);
}
