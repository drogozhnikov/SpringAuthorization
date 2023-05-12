package com.authorization.controller;

import com.authorization.dto.AdminDto;
import com.authorization.service.AdminService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@CrossOrigin //needed to Vue
@RequestMapping("/api/auth/admin")
public class AdminController {

    private AdminService service;

    public AdminController(AdminService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<AdminDto> getAccounts() {
        return service.readAll();
    }
}
