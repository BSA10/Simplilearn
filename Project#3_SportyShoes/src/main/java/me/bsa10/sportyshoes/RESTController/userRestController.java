package me.bsa10.sportyshoes.RESTController;

import me.bsa10.sportyshoes.model.user;
import me.bsa10.sportyshoes.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class userRestController {

    @Autowired
    private userService userService;

    @GetMapping("/all")
    public List<user> userList(){
        return userService.findAll();
    }

}
