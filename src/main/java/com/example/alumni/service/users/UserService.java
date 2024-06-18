package com.example.alumni.service.users;

import java.util.Optional;

import com.example.alumni.dto.UserDto;
import com.example.alumni.entity.User;

public interface UserService {
    Optional<User> findByUsername(String username);
    User save(UserDto userDto);
}
