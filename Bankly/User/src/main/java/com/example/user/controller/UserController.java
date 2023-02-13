package com.example.user.controller;

import com.example.user.dto.UserDTO;
import com.example.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.user.service.UserService;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping
    public List<UserDTO> ListUsers() {
        return userService.getAll();
    }
    @PostMapping("/register")
    public UserDTO register(@RequestBody User user){
        return userService.register(user);
    }
}
