package me.bsa10.sportyshoes.controller;

import me.bsa10.sportyshoes.model.user;
import me.bsa10.sportyshoes.model.user_address;
import me.bsa10.sportyshoes.service.cartService;
import me.bsa10.sportyshoes.service.order_detailsService;
import me.bsa10.sportyshoes.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;



@Controller
public class checkoutController {

    @Autowired
    private cartService cartService;

    @Autowired
    private userService userService;

    @Autowired
    private order_detailsService orderDetailsService;

    @GetMapping("/checkout")
    public String getcheckout(Principal principal , Model model){

        if(principal != null){
            user user = userService.findByUsername(principal.getName());
            model.addAttribute("user",user);
            if(user.getUser_address() == null)
                model.addAttribute("user_address" , new user_address());

            if(user.getCart() != null && user.getCart().size() > 0) {
                model.addAttribute("carts" , user.getCart());

                if(user.getCart() != null) {
                    double totalQuantity = 0;
                    for (int i = 0; i < user.getCart().size(); i++) {
                        totalQuantity += ( user.getCart().get(i).getProduct().getPrice() * user.getCart().get(i).getQuantity());
                    }
                    model.addAttribute("totalPrice", totalQuantity);
                }
                if(user.getCart() != null) {
                    int totalQuantity = user.getCart().size();
                    model.addAttribute("totalInCart", totalQuantity);
                }

            }
            return "checkout";

        }

        return "checkout";
    }


    @PostMapping("/checkout/add-userAddress")
    public String getAddress(
             @Valid @ModelAttribute("user_address") user_address user_address
            , BindingResult result
             , @Valid @ModelAttribute("user") user user
             , BindingResult result2
            , Principal principal
            ) {

        user = userService.findByUsername(principal.getName());
        if(result.hasErrors() && user.getUser_address() == null)
            return "checkout";




        if(user.getUser_address() == null){
        user.setUser_address(user_address);
        }

        return new orderCompleteController().getString(user, userService);
    }



}
