package com.manager.demo.project_impl.security;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SecurityUtil {

    public static final String ADMIN = "hasAuthority('ROLE_ADMIN')";
    public static final String ADMIN_AND_USER = "hasRole('ADMIN') or hasRole('USER')";
}