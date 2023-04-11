package com.manager.demo.project_impl.mappers;

import com.manager.demo.project_api.dto.SignupRequestDto;
import com.manager.demo.project_impl.mapper.UserMapper;
import com.manager.demo.project_impl.mapper.UserMapperImpl;
import org.junit.jupiter.api.Test;

import static com.manager.demo.project_impl.util.UserUnitTestGenerator.createSignupRequestDto;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserMapperTest {

    private final UserMapper userMapper = new UserMapperImpl();

    @Test
    void when_andOK() {
        SignupRequestDto signupRequestDto = createSignupRequestDto();
        var result = userMapper.toUser(signupRequestDto);

        assertEquals(result.getEmail(), signupRequestDto.getEmail());
        assertEquals(result.getPassword(), signupRequestDto.getPassword());
        assertEquals(result.getFirstName(), signupRequestDto.getFirstName());
        assertEquals(result.getLastName(), signupRequestDto.getLastName());
    }

}
