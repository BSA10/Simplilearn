package me.bsa.Learneracademy.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {


    @GetMapping("/")
    public String index(){
        return "index";
    }

}
