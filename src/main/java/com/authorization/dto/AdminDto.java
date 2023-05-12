package com.authorization.dto;

import com.authorization.model.Role;
import com.authorization.model.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AdminDto {

    private int id;
    private String username;
    private String email;
    private Role role;
    private Status status;

}
