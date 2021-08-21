package me.bsa10.sportyshoes.service;

import me.bsa10.sportyshoes.model.category;

import java.util.List;

public interface categoryService {

    void save(category category);
    void delete(category category);

    List<category> findAll();
    category findById(int categoryId);
    void deleteById(int categoryID);

}
