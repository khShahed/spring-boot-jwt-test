package com.example.spring_login_test.services;

import com.example.spring_login_test.dtos.UserResponse;
import com.example.spring_login_test.entities.User;
import com.example.spring_login_test.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserResponse getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();
        return mapUserToUserResponse(currentUser);
    }

    public List<UserResponse> allUsers() {
        List<UserResponse> users = new ArrayList<>();

        userRepository.findAll().forEach(user -> {
            users.add(mapUserToUserResponse(user));
        });

        return users;
    }

    private UserResponse mapUserToUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setName(user.getName());
        userResponse.setEmail(user.getEmail());
        userResponse.setCreatedAt(user.getCreatedAt());

        return userResponse;
    }
}
