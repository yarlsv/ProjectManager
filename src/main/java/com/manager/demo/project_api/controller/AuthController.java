package com.manager.demo.project_api.controller;

import com.manager.demo.project_api.dto.AuthenticationRequestDto;
import com.manager.demo.project_api.dto.SignupRequestDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Auth Controller", description = "Work with authorisation")
@RequestMapping(value = "/api/v1/auth")
public interface AuthController {

    ResponseEntity<?> authenticate(AuthenticationRequestDto authenticationRequestDto);
    void logout(HttpServletRequest request, HttpServletResponse response);
    ResponseEntity<?> registerUser(SignupRequestDto requestDto);

}
