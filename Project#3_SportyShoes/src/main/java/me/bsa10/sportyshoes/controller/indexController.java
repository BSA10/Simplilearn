package me.bsa10.sportyshoes.controller;

import me.bsa10.sportyshoes.model.cart;
import me.bsa10.sportyshoes.model.user;
import me.bsa10.sportyshoes.service.productService;
import me.bsa10.sportyshoes.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class indexController {

    @Autowired
    private productService productService;
    @Autowired
    private userService userService;

    @GetMapping("/")
    public String getIndex(Model model , Principal principal) {
        model.addAttribute("products",productService.findAll());

//
        if(principal != null) {
            user user = userService.findByUsername(principal.getName());
            model.addAttribute("user" , user);
            if(user.getCart() != null) {
                int totalQuantity = user.getCart().size();
                model.addAttribute("totalPrice", totalQuantity);
            }
        }

        return "index";

    }



}
