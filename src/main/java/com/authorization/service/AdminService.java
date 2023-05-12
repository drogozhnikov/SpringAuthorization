package com.authorization.service;

import com.authorization.dto.AdminDto;
import com.authorization.model.UserEntity;
import com.authorization.repository.UsersRepository;
import com.authorization.service.converter.AdminConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AdminService {

    private UsersRepository repository;
    private AdminConverter converter;

    public List<AdminDto> readAll(){
        List<UserEntity> userEntities = repository.findAll();
        if(userEntities.size()>0){
            return converter.convertAllToDto(userEntities);
        }
        return new ArrayList<>();
    }
}