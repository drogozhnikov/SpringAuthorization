package com.authorization.service;

import com.authorization.model.UserEntity;
import com.authorization.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private UsersRepository usersRepository;

    public Optional<UserEntity> findUserByUserName(String userName){
        return Optional.of(usersRepository.findUserByUsername(userName));
    }

}
