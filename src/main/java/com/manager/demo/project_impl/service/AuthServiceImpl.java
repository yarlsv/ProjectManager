package com.manager.demo.project_impl.service;

import com.manager.demo.project_api.dto.AuthenticationRequestDto;
import com.manager.demo.project_api.dto.MessageResponse;
import com.manager.demo.project_api.dto.SignupRequestDto;
import com.manager.demo.project_api.service.AuthService;
import com.manager.demo.project_db.entities.security.Role;
import com.manager.demo.project_db.entities.security.Status;
import com.manager.demo.project_db.entities.security.User;
import com.manager.demo.project_db.repositories.UserRepository;
import com.manager.demo.project_impl.mapper.UserMapper;
import com.manager.demo.project_impl.security.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final JwtUtils jwtUtils;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);


    @Override
    public ResponseEntity<?> authenticate(AuthenticationRequestDto requestDto) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requestDto.getEmail(), requestDto.getPassword()));
            User user = userRepository.findByEmail(requestDto.getEmail())
                    .orElseThrow(() -> new UsernameNotFoundException("User doesn't exists"));
            String token = jwtUtils.generateToken(requestDto.getEmail(), user.getRole().name());
            Map<Object, Object> response = new HashMap<>();
            response.put("email", requestDto.getEmail());
            response.put("token", token);

            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            return new ResponseEntity<>("Invalid email/password combination", HttpStatus.FORBIDDEN);
        }
    }

    @Override
    @Transactional
    public ResponseEntity<?> registerUser(SignupRequestDto requestDto) {
        if(Boolean.TRUE.equals(userRepository.existsByEmail(requestDto.getEmail()))) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use"));
        }

        User user = userMapper.toUser(requestDto);
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        user.setId(UUID.randomUUID());
        user.setStatus(Status.ACTIVE);

        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
