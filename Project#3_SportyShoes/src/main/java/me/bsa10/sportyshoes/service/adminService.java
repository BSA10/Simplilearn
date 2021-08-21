package me.bsa10.sportyshoes.service;

import me.bsa10.sportyshoes.model.admin;


import java.util.List;

public interface adminService {

    void save(admin admin);
    void delete(admin admin);

    List<admin> findAll();
    admin findById(int adminId);
    void deleteById(int adminId);
}
