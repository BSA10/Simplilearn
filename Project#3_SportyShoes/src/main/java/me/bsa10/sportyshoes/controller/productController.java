package me.bsa10.sportyshoes.controller;

import me.bsa10.sportyshoes.service.productService;
import me.bsa10.sportyshoes.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class productController {
    @Autowired
    private userService userService;
    @Autowired
    private productService productService;

    @GetMapping("/product-detail")
    public String getProductDetail(@RequestParam("productId") int productId, Model model)
    {
        model.addAttribute("product" , productService.findById(productId));

        return "product-detail";
    }


}
