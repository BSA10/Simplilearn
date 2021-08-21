package me.bsa10.sportyshoes.service.Impl;

import me.bsa10.sportyshoes.model.product;
import me.bsa10.sportyshoes.repository.productDAO;
import me.bsa10.sportyshoes.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class productServiceImpl implements productService {

    @Autowired
    private productDAO productDAO;

    @Override
    public void save(product product) {
        productDAO.save(product);
    }

    @Override
    public void delete(product product) {
        productDAO.delete(product);
    }

    @Override
    public List<product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public product findById(int productId) {
        Optional<product> product = productDAO.findById(productId);
        return product.get();
    }

    @Override
    public void deleteById(int productId) {
        productDAO.deleteById(productId);
    }
}
