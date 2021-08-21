package me.bsa10.sportyshoes.service.Impl;


import me.bsa10.sportyshoes.model.user_address;
import me.bsa10.sportyshoes.repository.user_addressDAO;
import me.bsa10.sportyshoes.service.user_addressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class user_addressServiceImpl implements user_addressService {

    @Autowired
    private user_addressDAO user_addressDAO;

    @Override
    public void save(user_address user_address) {
        user_addressDAO.save(user_address);
    }

    @Override
    public void delete(user_address user_address) {
        user_addressDAO.delete(user_address);
    }

    @Override
    public List<user_address> findAll() {
        return user_addressDAO.findAll();
    }

    @Override
    public user_address findById(int user_addressId) {
        Optional<user_address> user_address = user_addressDAO.findById(user_addressId);
        return user_address.get();
    }

    @Override
    public void deleteById(int user_addressId) {
        user_addressDAO.deleteById(user_addressId);
    }
}
