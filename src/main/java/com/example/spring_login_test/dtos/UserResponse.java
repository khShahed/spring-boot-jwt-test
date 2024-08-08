package com.example.spring_login_test.dtos;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
    private Integer id;
    private String name;
    private String email;
    private Date createdAt;
}
