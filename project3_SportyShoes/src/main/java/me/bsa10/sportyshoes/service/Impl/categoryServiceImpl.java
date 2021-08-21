package me.bsa10.sportyshoes.service.Impl;

import me.bsa10.sportyshoes.model.category;
import me.bsa10.sportyshoes.repository.categoryDAO;
import me.bsa10.sportyshoes.service.categoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class categoryServiceImpl implements categoryService {

    @Autowired
    private categoryDAO categoryDAO;

    @Override
    public void save(category category) {
        categoryDAO.save(category);
    }

    @Override
    public void delete(category category) {
        categoryDAO.delete(category);
    }

    @Override
    public List<category> findAll() {
        return categoryDAO.findAll();
    }

    @Override
    public category findById(int categoryId) {
        Optional<category> category = categoryDAO.findById(categoryId);
        return category.get();
    }

    @Override
    public void deleteById(int categoryID) {
        categoryDAO.deleteById(categoryID);
    }
}
