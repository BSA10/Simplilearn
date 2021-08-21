package me.bsa10.sportyshoes.service;

import me.bsa10.sportyshoes.model.user;

import java.util.List;

public interface userService {

    void save(user user);
    void delete(user user);

    List<user> findAll();
    user findById(int userId);
    void deleteById(int userId);

    user findByUsername(String username);

}
