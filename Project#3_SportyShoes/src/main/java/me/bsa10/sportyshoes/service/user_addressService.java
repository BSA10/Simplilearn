package me.bsa10.sportyshoes.service;


import me.bsa10.sportyshoes.model.user_address;

import java.util.List;

public interface user_addressService {

    void save(user_address user_address);
    void delete(user_address user_address);

    List<user_address> findAll();
    user_address findById(int user_addressId);
    void deleteById(int user_addressId);
}
