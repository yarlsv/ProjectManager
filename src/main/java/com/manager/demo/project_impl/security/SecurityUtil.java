package com.manager.demo.project_impl.security;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SecurityUtil {

    public static final String ADMIN = "hasRole('ROLE_ADMIN')";
    public static final String ADMIN_AND_USER = "hasAnyRole('ROLE_ADMIN', 'ROLE_USER)";
}