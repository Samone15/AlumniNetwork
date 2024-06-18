package com.example.alumni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.alumni.dto.UserDto;
import com.example.alumni.entity.User;
import com.example.alumni.service.UserService;

@Controller
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute("userDto") UserDto userDto, Model model) {
        User user = userService.findByUsername(userDto.getUsername());
        
        if (user != null && passwordEncoder.matches(userDto.getPassword(), user.getPassword())) {
            return "redirect:/home";
        } else {
            System.out.println("Attempting to log in with user: " + userDto.getUsername());
        if (user != null) {
            System.out.println("Retrieved user from database: " + user);
            System.out.println("Stored password: " + user.getPassword());
            System.out.println("Entered password: " + userDto.getPassword());
        } else {
            System.out.println("No user found with username: " + userDto.getUsername());
        }
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "register";
    }

    @PostMapping("/register")
    public String registerSubmit(@ModelAttribute("userDto") UserDto userDto, Model model) {
        User user = userService.save(userDto);
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String homeForm(Model model) {
        model.addAttribute("message", "Welcome to the Home Page!");
        return "home";
    }
}