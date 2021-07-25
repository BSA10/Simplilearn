package me.bsa.Learneracademy.Service.impl;

import me.bsa.Learneracademy.Model.classes;
import me.bsa.Learneracademy.Repository.classesDao;
import me.bsa.Learneracademy.Service.classesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class classesServiceImpl implements classesService {

    @Autowired
    private classesDao classesDao;

    @Override
    public void create(classes classes) {
        classesDao.save(classes);
    }

    @Override
    public void delete(classes classes) {
        classesDao.delete(classes);
    }

    @Override
    public void deleteById(int id) {
        classesDao.deleteById(id);
    }

    @Override
    public List<classes> listAll() {
        return classesDao.findAll();
    }

    @Override
    public classes findById(int class_id) {
        Optional<classes> temp = classesDao.findById(class_id);


        return temp.get();
    }

    public void test(){

    }
}
