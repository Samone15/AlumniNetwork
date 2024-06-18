package com.example.alumni.controller.loginCont;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.alumni.controller.Valid;
import com.example.alumni.dto.UserDto;
import com.example.alumni.service.users.UserService;

@Controller
public class RegisterController {

    private final UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "register";
    }

    @PostMapping("/register")
    public String registerSubmit(@ModelAttribute("userDto") @Valid UserDto userDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "register"; // Return to registration form if there are validation errors
        }

        try {
            userService.save(userDto);
            return "redirect:/login"; // Redirect to login page after successful registration
        } catch (Exception e) {
            model.addAttribute("error", "Error: " + e.getMessage());
            return "register"; // Return to registration form with error message
        }
    }
}

