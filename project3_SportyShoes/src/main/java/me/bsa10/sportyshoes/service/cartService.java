package me.bsa10.sportyshoes.service;

import me.bsa10.sportyshoes.model.cart;


import java.util.List;

public interface cartService {
    void save(cart cart);
    void delete(cart cart);

    List<cart> findAll();
    cart findById(int cartId);
    void deleteById(int cartId);
}
