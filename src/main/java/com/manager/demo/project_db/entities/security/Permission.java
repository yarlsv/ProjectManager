package com.manager.demo.project_db.entities.security;

public enum Permission {
    PROJECT_READ("project:read"),
    PROJECT_WRITE("project:write");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}