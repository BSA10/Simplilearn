package me.bsa10.sportyshoes.controller;


import me.bsa10.sportyshoes.model.cart;
import me.bsa10.sportyshoes.model.order_details;
import me.bsa10.sportyshoes.model.user;
import me.bsa10.sportyshoes.service.cartService;
import me.bsa10.sportyshoes.service.order_detailsService;
import me.bsa10.sportyshoes.service.userService;
import me.bsa10.sportyshoes.service.user_addressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.security.Principal;
import java.util.Date;
import java.util.List;

@Controller
public class orderCompleteController {


    @GetMapping("/order-complete")
    public String getOrderComplete(){
        return "order-complete";
    }

    @Autowired
    private cartService cartService;

    @Autowired
    private userService userService;

    @Autowired
    private order_detailsService orderDetailsService;


    @GetMapping("/checkout/order-complete")
    public String orderWithSelectedAddress(Principal principal,@RequestParam("address") int addressId){

        user user = userService.findByUsername(principal.getName());

        return getString(user, userService);
    }

    public String getString(user user, userService userService) {
        if(user.getCart() != null){
            order_details order_details = new order_details();
            order_details.setStatus("Success");

            double totalQuantity = 0;
            for (int i = 0; i < user.getCart().size(); i++) {
                totalQuantity += ( user.getCart().get(i).getProduct().getPrice() * user.getCart().get(i).getQuantity());
            }
            order_details.setTotal(totalQuantity);
            order_details.setCreated_at(new Date().getTime());
            for (cart c : user.getCart()){
                order_details.addProduct(c.getProduct());
                c.getProduct().addOrderDetails(order_details);
            }
            order_details.setUser(user);
            user.addOrder_details(order_details);

            List<cart> cart = user.getCart();
            user.setCart(null);
            for(cart x : cart)
                cartService.deleteById(x.getId());

            userService.save(user);
        }
        else {
            return "redirect:/checkout";
        }


        return "redirect:/order-complete";
    }


}
