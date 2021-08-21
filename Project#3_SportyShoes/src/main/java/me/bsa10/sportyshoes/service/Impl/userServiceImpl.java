package me.bsa10.sportyshoes.service.Impl;

import me.bsa10.sportyshoes.model.user;
import me.bsa10.sportyshoes.repository.userDAO;
import me.bsa10.sportyshoes.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class userServiceImpl implements userService {

    @Autowired
    private userDAO userDAO;

    @Override
    public void save(user user) {
        userDAO.save(user);
    }

    @Override
    public void delete(user user) {
        userDAO.delete(user);
    }

    @Override
    public List<user> findAll() {
        return userDAO.findAll();
    }

    @Override
    public user findById(int userId) {
        Optional<user> tempUser = userDAO.findById(userId);
        return tempUser.get();
    }

    @Override
    public void deleteById(int userId) {
        userDAO.deleteById(userId);
    }

    @Override
    public user findByUsername(String username) {
        return userDAO.findByUsername(username);
    }
}
