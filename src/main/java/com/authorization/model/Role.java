package com.authorization.model;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    MANAGER(Set.of(Permission.DEVELOPERS_READ)),
    DIRECTOR(Set.of(Permission.DEVELOPERS_READ)),
    STORAGE_MANAGER(Set.of(Permission.DEVELOPERS_READ, Permission.DEVELOPERS_WRITE)),
    USER(Set.of(Permission.DEVELOPERS_READ, Permission.DEVELOPERS_WRITE));

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities(){
        return  getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }


}
