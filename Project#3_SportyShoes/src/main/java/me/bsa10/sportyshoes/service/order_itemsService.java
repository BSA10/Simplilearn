package me.bsa10.sportyshoes.service;

import me.bsa10.sportyshoes.model.order_details;
import me.bsa10.sportyshoes.model.order_items;

import java.util.List;

public interface order_itemsService {
    void save(order_items order_items);
    void delete(order_items order_items);

    List<order_items> findAll();
    order_items findById(int order_itemsId);
    void deleteById(int order_itemsId);
}
