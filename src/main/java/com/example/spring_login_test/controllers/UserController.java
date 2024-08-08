package com.example.spring_login_test.controllers;

import com.example.spring_login_test.dtos.UserResponse;
import com.example.spring_login_test.entities.User;
import com.example.spring_login_test.services.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/users")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @GetMapping("/me")
    public ResponseEntity<UserResponse> authenticatedUser() {
        return ResponseEntity.ok(userService.getCurrentUser());
    }

    @GetMapping("/")
    public ResponseEntity<List<UserResponse>> allUsers() {
        List <UserResponse> users = userService.allUsers();

        return ResponseEntity.ok(users);
    }
}
