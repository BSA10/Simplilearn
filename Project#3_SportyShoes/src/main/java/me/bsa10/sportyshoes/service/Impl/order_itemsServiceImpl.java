package me.bsa10.sportyshoes.service.Impl;

import me.bsa10.sportyshoes.model.order_items;
import me.bsa10.sportyshoes.repository.order_itemsDAO;
import me.bsa10.sportyshoes.service.order_itemsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class order_itemsServiceImpl implements order_itemsService {

    private order_itemsDAO orderItemsDAO;

    @Override
    public void save(order_items order_items) {
        orderItemsDAO.save(order_items);
    }

    @Override
    public void delete(order_items order_items) {
        orderItemsDAO.delete(order_items);
    }

    @Override
    public List<order_items> findAll() {
        return orderItemsDAO.findAll();
    }

    @Override
    public order_items findById(int order_itemsId) {
        Optional<order_items> order_items = orderItemsDAO.findById(order_itemsId);
        return order_items.get();
    }

    @Override
    public void deleteById(int order_itemsId) {
        orderItemsDAO.deleteById(order_itemsId);
    }
}
