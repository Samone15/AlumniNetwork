package com.example.alumni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.alumni.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
    User findByUsername(String username);
}
