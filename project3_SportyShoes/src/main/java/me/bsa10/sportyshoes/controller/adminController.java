package me.bsa10.sportyshoes.controller;


import me.bsa10.sportyshoes.model.category;
import me.bsa10.sportyshoes.model.product;
import me.bsa10.sportyshoes.model.user;
import me.bsa10.sportyshoes.model.user_address;
import me.bsa10.sportyshoes.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class adminController {

    @Autowired
    private userService userService;
    @Autowired
    private productService productService;
    @Autowired
    private user_addressService user_addressService;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private categoryService categoryService;
    @Autowired
    private order_detailsService orderDetailsService;


    @GetMapping("/admin/dashboard")
    public String getDashboard(Model model){

        return "dashboard";
    }


    /*
         ** Users **
     */

    @GetMapping("/admin/dashboard/users")
    public String getUsers(Model model ){
        model.addAttribute("users",userService.findAll());
        return "users";
    }
    @GetMapping("/admin/dashboard/search")
    public String getSearch(@RequestParam(name = "userName",required = false) String userName , Model model){
        model.addAttribute("users" , userService.findByUsername(userName));
        return "users";
    }
    @GetMapping("/admin/dashboard/users/user-details")
    public String getUserDetails(@RequestParam("userId") int userId , Model model){
        model.addAttribute("user" , userService.findById(userId));
        return "user-details";
    }
    @GetMapping("/admin/dashboard/users/user-details/user-address")
    public String getUserAddress(@RequestParam("userId") int userId , Model model){
        model.addAttribute("user" , userService.findById(userId));
        return "user-address";
    }

    @GetMapping("/admin/dashboard/users/add-user")
    public String getAddUser(Model model){
        model.addAttribute("user" , new user());
        return "add-user";
    }
    @GetMapping("/admin/dashboard/users/update-user")
    public String updateUser(@RequestParam("userId") int userId ,Model model){

        model.addAttribute("user" , userService.findById(userId));
        return "add-user";
    }
    @GetMapping("/admin/dashboard/users/user-details/user-address/add")
    public String getAddUserAddress(@RequestParam("userId")int userId ,Model model){
        model.addAttribute("user" , userService.findById(userId));
        model.addAttribute("user_address" , new user_address());
        return "add-user-address";
    }
    @GetMapping("/admin/dashboard/users/user-details/user-address/update-user-address")
    public String updateUserAddress(@RequestParam("userId") int userId ,Model model){

        model.addAttribute("user" , userService.findById(userId));
        return "add-user-address";
    }
    @GetMapping("/admin/dashboard/users/delete")
    public String deleteUser(@RequestParam("userId") int userId){
        if(userId > 0){
            userService.deleteById(userId);
        }
        return "redirect:/admin/dashboard/users";
    }
    @GetMapping("/admin/dashboard/users/user-details/user-address/delete")
    public String deleteUserAddress(@RequestParam("user_address_id") int user_address_id , @RequestParam("userId") int userId){
        if(user_address_id > 0){
            user user = userService.findById(userId);
            user.setUser_address(null);
            userService.save(user);
            user_addressService.deleteById(user_address_id);

        }
        return "redirect:/admin/dashboard/users/user-details?userId="+userId;
    }


    /*
     ** End of Users **
     */



    /*
            ** Category Methods **
     */

    @GetMapping("/admin/dashboard/category")
    public String getCategory(Model model){
        model.addAttribute("categories" , categoryService.findAll());
        return "category";
    }
    @GetMapping("/admin/dashboard/category/add")
    public String getAddCategory(Model model){
        model.addAttribute("category" , new category());
        return "add-category";
    }
    @GetMapping("/admin/dashboard/category/update")
    public String getUpdateCategory(@RequestParam("categoryId") int categoryId , Model model){
        model.addAttribute("category" , categoryService.findById(categoryId));
        return "add-category";
    }
    @GetMapping("/admin/dashboard/category/delete")
    public String deleteCategory(Model model){
        model.addAttribute("Categories" , categoryService.findAll());
        return "redirect:/admin/dashboard/category";
    }
    @PostMapping("/admin/dashboard/category/add")
    public String addCategory(@ModelAttribute("category") category category , BindingResult result){
        if (result.hasErrors())
            return "add-category";


        categoryService.save(category);


        return "redirect:/admin/dashboard/category";
    }

    /*
           -- End of Categories --
     */


    /*
            ** Products **
     */
    @GetMapping("/admin/dashboard/products")
    public String getProducts(Model model){
        model.addAttribute("products" , productService.findAll());
        return "products";
    }
    @GetMapping("/admin/dashboard/products-table")
    public String getProduct(Model model){
        return "products-table";
    }

    @GetMapping("/admin/dashboard/products/add-product")
    public String getAddProduct(Model model){
        model.addAttribute("product" , new product());
        model.addAttribute("categories" , categoryService.findAll());
        return "add-product";
    }
    @GetMapping("/admin/dashboard/products/update-product")
    public String updateProudct(@RequestParam("productId") int productId  ,Model model){


        model.addAttribute("product" , productService.findById(productId));
        return "add-product";
    }
    @GetMapping("/admin/dashboard/products/delete")
    public String deleteProduct(@RequestParam("productId") int productId){
        if(productId > 0){
            productService.deleteById(productId);
        }
        return "redirect:/admin/dashboard/products";
    }

    /*
        ** End of Products **
     */

    /*
            ** Purchase Report **
     */
    @GetMapping("/admin/dashboard/purchase-report")
    public String getReport(Model model ){
        model.addAttribute("purchase", orderDetailsService.findAll());
        return "purchase-report";
    }


    // Post Methods

    @PostMapping("/admin/dashboard/products/add-product")
    public String addProduct(@ModelAttribute("product") product product , BindingResult result
                ,@RequestParam("categoryId") int categoryId){

        if(result.hasErrors()){
            return "add-product";
        }

        if(product.getCreated_at() <= 0)
            product.setCreated_at(new Date().getTime());
        category category = categoryService.findById(categoryId);
        category.addProduct(product);
        product.addCategory(category);
        productService.save(product);
        return "redirect:/admin/dashboard/products";
    }

    @PostMapping("/admin/dashboard/users/user-details/user-address/add")
    public String addUserAddress(@RequestParam("userId") int userId
                                 ,@ModelAttribute("user_address") user_address user_address

             ){


        System.out.println(userId);
        user user = userService.findById(userId);
        user.setUser_address(user_address);
        userService.save(user);
        return "redirect:/admin/dashboard/users/user-details/user-address?userId="+userId;
    }

    @PostMapping("/admin/dashboard/users/add-user")
    public String addUser(@ModelAttribute("user") user user , BindingResult result){

        if(result.hasErrors())
            return "add-user";

        if(user == null){
            user.setPassword(encoder.encode(user.getPassword()));
            user.setCreated_at(new Date().getTime());
        }
        if(user.getPassword().matches("[A-Za-z0-9]+")){
            user.setPassword(encoder.encode(user.getPassword()));
        }

        userService.save(user);
        return "redirect:/admin/dashboard/users";
    }



}
