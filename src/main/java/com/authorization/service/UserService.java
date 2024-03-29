package com.authorization.service;

import com.authorization.dto.UserDto;
import com.authorization.exception.AuthUserException;
import com.authorization.model.UserEntity;
import com.authorization.repository.UsersRepository;
import com.authorization.service.converter.UserConverter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private UsersRepository usersRepository;
    private UserConverter converter;

    public Optional<UserEntity> findUserByUserName(String userName) {
        return Optional.of(usersRepository.findUserByUsername(userName));
    }

    public UserDto save(UserDto input) {
        UserEntity savedEntity = new UserEntity();
        try {
            usersRepository.save(converter.convertToEntity(input));
        } catch (Exception e) {
            throw new AuthUserException("existing username or email", HttpStatus.BAD_REQUEST);
        }
        return converter.convertToDto(savedEntity);
    }

    public void delete(String userName) {
        Optional<UserEntity> entity = Optional.ofNullable(usersRepository.findUserByUsername(userName));
        entity.ifPresent(foundedEntity -> usersRepository.delete(entity.get()));
    }

}
