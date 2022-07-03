package com.demoUserManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {
    @Autowired
    private  UsersRepository usersRepository;

    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/register")
    public String showSignupForm(Model model){
        model.addAttribute("user", new Users());

        return "signup_form";
    }

    @PostMapping("/process_register")
    public String registerUser(Users user){
            usersRepository.save(user);

            return "register_success";
    }
}