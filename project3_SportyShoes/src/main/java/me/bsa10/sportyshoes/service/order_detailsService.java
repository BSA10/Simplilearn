package me.bsa10.sportyshoes.service;

import me.bsa10.sportyshoes.model.cart;
import me.bsa10.sportyshoes.model.order_details;

import java.util.List;

public interface order_detailsService {

    void save(order_details order_details);
    void delete(order_details order_details);

    List<order_details> findAll();
    order_details findById(int order_detailsId);
    void deleteById(int order_detailsId);
}
