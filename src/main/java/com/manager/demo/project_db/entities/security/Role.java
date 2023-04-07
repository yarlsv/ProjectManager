package com.manager.demo.project_db.entities.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@RequiredArgsConstructor
public enum Role implements GrantedAuthority {
    USER("USER"),
    ADMIN("ADMIN");

    private final String vale;

    @Override
    public String getAuthority() {
        return vale;
    }
}
