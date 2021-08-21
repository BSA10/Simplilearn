package me.bsa10.sportyshoes.controller;

import me.bsa10.sportyshoes.model.cart;
import me.bsa10.sportyshoes.model.product;
import me.bsa10.sportyshoes.model.user;
import me.bsa10.sportyshoes.service.cartService;
import me.bsa10.sportyshoes.service.productService;
import me.bsa10.sportyshoes.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Date;
import java.util.List;

@Controller
public class cartController {

    @Autowired
    private cartService cartService;
    @Autowired
    private productService productService;
    @Autowired
    private userService userService;


    @GetMapping("/cart")
    public String getCart(Principal principal , Model model){ // refactoring

        if(principal != null){
            user user = userService.findByUsername(principal.getName());
            model.addAttribute("user",user);
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
            return "cart";
        }

        return "redirect:/login";
    }




    @PostMapping("/cart/add-to-cart")
    public String addCart(@ModelAttribute("cart") cart cart
//                            , @ModelAttribute("product") product product
                            , @RequestParam("productId") int productId
                            , Principal principal){
        user user = new user();
        if (principal != null) {
            user = userService.findByUsername(principal.getName());
            boolean found = false;
            cart cart1 = new cart();
            if(!user.getCart().isEmpty()) {
                for (int i = 0; i < user.getCart().size(); i++) { // check if the cart of products already exists and make it quantity
                    if (user.getCart().get(i).getProduct().getId() == productId) {
                        found = true;
                        cart1 = user.getCart().get(i);
                    }

                }

            }

            if (found) {
                cart1.setQuantity(cart1.getQuantity() + 1);
                user.addCart(cart1);
                userService.save(user);
            } else {
                cart = new cart();
                cart.setQuantity(1);
                cart.setCreated_at(new Date().getTime());
                cart.setProduct(productService.findById(productId));
                cart.setUser(user);
                user.addCart(cart);

                userService.save(user);
            }
            return "redirect:/cart";
        }

            return "redirect:/login";
    }

    @GetMapping("/cart/delete")
    public String deleteCart(@RequestParam("cartId") int cartId , Principal principal){

        if(cartId > 0){
            user user = userService.findByUsername(principal.getName());
            user.setCart(null);
            cartService.deleteById(cartId);
        }

        return "redirect:/cart";
    }



}
