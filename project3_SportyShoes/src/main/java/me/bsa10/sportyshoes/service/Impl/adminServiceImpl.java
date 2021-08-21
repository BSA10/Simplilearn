package me.bsa10.sportyshoes.service.Impl;

import lombok.AllArgsConstructor;
import me.bsa10.sportyshoes.model.admin;
import me.bsa10.sportyshoes.repository.adminDAO;
import me.bsa10.sportyshoes.service.adminService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class adminServiceImpl implements adminService {

    @Autowired
    private adminDAO adminDAO;

    @Override
    public void save(admin admin) {
        adminDAO.save(admin);
    }

    @Override
    public void delete(admin admin) {
        adminDAO.delete(admin);
    }

    @Override
    public List<admin> findAll() {
        return adminDAO.findAll();
    }

    @Override
    public admin findById(int adminId) {
        Optional<admin> admin = adminDAO.findById(adminId);
        return admin.get();
    }

    @Override
    public void deleteById(int adminId) {
        adminDAO.deleteById(adminId);
    }
}
