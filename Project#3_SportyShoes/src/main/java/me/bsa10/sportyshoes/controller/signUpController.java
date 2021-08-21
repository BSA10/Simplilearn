package me.bsa10.sportyshoes.controller;

import me.bsa10.sportyshoes.model.user;
import me.bsa10.sportyshoes.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
public class signUpController {

    @Autowired
    private userService userService;
    @Autowired
    private PasswordEncoder encoder;


    @GetMapping("/sign-up")
    public String getSignUpIndex(Model model){
        model.addAttribute("user" , new user());
        return "sign-up";
    }


    @PostMapping("/sign-up")
    public String signUp(@ModelAttribute("user") user user){
        if(!user.getUsername().equals(userService.findByUsername(user.getUsername()).getUsername())){
        user.setCreated_at(new Date().getTime());
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole("USER_ROLE");
        user.setEnable(true);
        userService.save(user);
            return "redirect:/login";
        }
        return "redirect:/sign-up";

    }

}
