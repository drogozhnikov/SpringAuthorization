package com.authorization.repository;

import com.authorization.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findUserByUsername(String name);

}
