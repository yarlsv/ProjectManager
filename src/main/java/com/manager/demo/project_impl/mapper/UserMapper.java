package com.manager.demo.project_impl.mapper;

import com.manager.demo.project_api.config.MapperConfig;
import com.manager.demo.project_api.dto.SignupRequestDto;
import com.manager.demo.project_db.entities.security.User;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface UserMapper {

    User toUser(SignupRequestDto signupRequestDto);
}
