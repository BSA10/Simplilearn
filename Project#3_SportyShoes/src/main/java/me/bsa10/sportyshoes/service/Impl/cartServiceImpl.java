package me.bsa10.sportyshoes.service.Impl;

import me.bsa10.sportyshoes.model.cart;
import me.bsa10.sportyshoes.repository.cartDAO;
import me.bsa10.sportyshoes.service.cartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class cartServiceImpl implements cartService {

    @Autowired
    private cartDAO cartDAO;

    @Override
    public void save(cart cart) {
        cartDAO.save(cart);
    }

    @Override
    public void delete(cart cart) {
        cartDAO.delete(cart);
    }

    @Override
    public List<cart> findAll() {
        return cartDAO.findAll();
    }

    @Override
    public cart findById(int cartId) {
        Optional<cart> tempCart = cartDAO.findById(cartId);
        return tempCart.get();
    }

    @Override
    public void deleteById(int cartId) {
        cartDAO.deleteById(cartId);
    }
}
