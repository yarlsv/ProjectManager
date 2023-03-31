package com.manager.demo.project_api.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Auth Controller", description = "Work with authorisation")
@RequestMapping("/api/v1/auth")
public interface AuthController {


}
