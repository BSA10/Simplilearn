package me.bsa10.sportyshoes.RESTController;

import me.bsa10.sportyshoes.model.order_details;
import me.bsa10.sportyshoes.service.order_detailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class orderRestController {

    @Autowired
    private order_detailsService orderDetailsService;

    @GetMapping("/all")
    public List<order_details> getAll(){
        return orderDetailsService.findAll();
    }

}
