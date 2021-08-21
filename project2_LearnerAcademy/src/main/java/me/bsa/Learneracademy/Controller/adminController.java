package me.bsa.Learneracademy.Controller;

import me.bsa.Learneracademy.Model.student;
import me.bsa.Learneracademy.Model.users;
import me.bsa.Learneracademy.Service.impl.usersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class adminController {

    @Autowired
    private usersServiceImpl usersService;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping("/admin")
    public String adminIndex(Model model){
        model.addAttribute("admin" , usersService.listAll());
        return "admin";
    }

    @GetMapping("/add-admin")
    public String addADmin(Model model){
        model.addAttribute("admin" , new users());
        return "add-admin";
    }

    @GetMapping("/admin/delete")
    public String deleteAdmin(@RequestParam("adminId") int adminId){
        usersService.deleteById(adminId);
        return "redirect:/admin";
    }

    @GetMapping("/update-admin")
    public String updateAdmin(@RequestParam("adminId") int userId , Model model){
        users user = usersService.findById(userId);
        model.addAttribute("admin",user);
        return "add-admin";
    }


    @PostMapping("/add-admin")
    public String addAdmin(@ModelAttribute("admin") users user){
        //  @RequestParam(value = "class_id",required = false) int admin_id
        user.setRole("ADMIN_ROLE");
        user.setEnable(1);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        usersService.create(user);
        return "redirect:/admin";
    }

}
