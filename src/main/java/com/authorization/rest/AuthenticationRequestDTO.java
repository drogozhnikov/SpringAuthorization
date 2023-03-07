package com.authorization.rest;

import lombok.Data;

@Data
public class AuthenticationRequestDTO {
    private String userName;
    private String password;
}
