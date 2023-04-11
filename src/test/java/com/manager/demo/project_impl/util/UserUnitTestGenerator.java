package com.manager.demo.project_impl.util;

import com.manager.demo.project_api.dto.SignupRequestDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserUnitTestGenerator {

    public static SignupRequestDto createSignupRequestDto() {
        SignupRequestDto signupRequestDto = new SignupRequestDto();

        signupRequestDto.setPassword("12345");
        signupRequestDto.setEmail("manager@yandex.ru");
        signupRequestDto.setFirstName("Anton");
        signupRequestDto.setLastName("Antonov");

        return signupRequestDto;
    }
}
