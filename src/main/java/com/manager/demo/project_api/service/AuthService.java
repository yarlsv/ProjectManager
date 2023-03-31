package com.manager.demo.project_api.service;

import com.manager.demo.project_api.dto.AuthenticationRequestDto;
import com.manager.demo.project_api.dto.SignupRequestDto;
import org.springframework.http.ResponseEntity;

public interface AuthService {

    ResponseEntity<?> authenticate(AuthenticationRequestDto requestDto);
    ResponseEntity<?> registerUser(SignupRequestDto requestDto);

}
