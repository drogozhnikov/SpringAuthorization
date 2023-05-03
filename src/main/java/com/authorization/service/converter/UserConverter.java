package com.authorization.service.converter;

import com.authorization.dto.UserDto;
import com.authorization.model.Role;
import com.authorization.model.Status;
import com.authorization.model.UserEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class UserConverter {

    public UserDto convertToDto(UserEntity entity) {
        return UserDto.builder()
                .username(entity.getUsername())
                .build();
    }

    public UserEntity convertToEntity(UserDto dto) {
        return UserEntity.builder()
                .username(dto.getUsername())
                .password(new BCryptPasswordEncoder(12).encode(dto.getPassword()))
                .email(dto.getEmail())
                .role(Role.USER)
                .status(Status.ACTIVE)
                .created(new Timestamp(System.currentTimeMillis()))
                .updated(new Timestamp(System.currentTimeMillis()))
                .build();
    }
}
