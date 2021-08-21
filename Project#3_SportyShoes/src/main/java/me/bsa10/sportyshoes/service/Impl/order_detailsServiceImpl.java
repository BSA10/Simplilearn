package me.bsa10.sportyshoes.service.Impl;

import me.bsa10.sportyshoes.model.order_details;
import me.bsa10.sportyshoes.model.order_items;
import me.bsa10.sportyshoes.repository.order_detailsDAO;
import me.bsa10.sportyshoes.service.order_detailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class order_detailsServiceImpl implements order_detailsService {

    @Autowired
    private order_detailsDAO detailsDAO;

    @Override
    public void save(order_details order_details) {
        detailsDAO.save(order_details);
    }

    @Override
    public void delete(order_details order_details) {
        detailsDAO.delete(order_details);
    }

    @Override
    public List<order_details> findAll() {
        return detailsDAO.findAll();
    }

    @Override
    public order_details findById(int order_detailsId) {
        Optional<order_details> order_details = detailsDAO.findById(order_detailsId);
        return order_details.get();
    }

    @Override
    public void deleteById(int order_detailsId) {
        detailsDAO.deleteById(order_detailsId);
    }
}
