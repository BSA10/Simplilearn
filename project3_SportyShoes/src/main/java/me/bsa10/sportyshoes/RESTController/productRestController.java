package me.bsa10.sportyshoes.RESTController;


import me.bsa10.sportyshoes.model.product;
import me.bsa10.sportyshoes.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class productRestController {

    @Autowired
    private productService productService;


    @PostMapping("/add-product")
    public ResponseEntity<product> addProduct(@RequestBody product product){

        if(product != null)
        {
            product.setCreated_at(new Date().getTime());
            productService.save(product);
            return new ResponseEntity<product>(HttpStatus.OK);
        }
        else{
            System.out.println("Empty");
            return new ResponseEntity<product>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/admin/dashboard/products-r")
    public List<product> getProducts(){

        return productService.findAll();
    }



}
