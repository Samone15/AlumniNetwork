package com.example.alumni.service;

import com.example.alumni.dto.UserDto;
import com.example.alumni.entity.User;

public interface UserService {
    User findByUsername(String username);
    User save(UserDto userDto);
}
