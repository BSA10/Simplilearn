package me.bsa.Learneracademy.Service.impl;

import me.bsa.Learneracademy.Model.users;
import me.bsa.Learneracademy.Repository.usersDao;
import me.bsa.Learneracademy.Service.usersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class usersServiceImpl implements usersService {

    @Autowired
    private usersDao usersDao;

    @Override
    public void create(users user) {
        usersDao.save(user);
    }

    @Override
    public void delete(users user) {
        usersDao.delete(user);
    }

    @Override
    public void deleteById(int id) {
        usersDao.deleteById(id);
    }

    @Override
    public List<users> listAll() {
        return usersDao.findAll();
    }

    @Override
    public users findById(int userId) {
        Optional<users> user = usersDao.findById(userId);
        return user.get();
    }
}
