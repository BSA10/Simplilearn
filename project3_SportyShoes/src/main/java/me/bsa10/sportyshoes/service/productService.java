package me.bsa10.sportyshoes.service;

import me.bsa10.sportyshoes.model.cart;
import me.bsa10.sportyshoes.model.product;

import java.util.List;

public interface productService {

    void save(product product);
    void delete(product product);

    List<product> findAll();
    product findById(int productId);
    void deleteById(int productId);
}
