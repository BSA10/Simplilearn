package me.bsa.Learneracademy.Service.impl;

import me.bsa.Learneracademy.Model.teacher;
import me.bsa.Learneracademy.Repository.teacherDao;
import me.bsa.Learneracademy.Service.teacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class teacherServiceImpl implements teacherService {

    @Autowired
    private teacherDao teacherDao;

    @Override
    public void create(teacher teacher) {
        teacherDao.save(teacher);
    }

    @Override
    public void delete(teacher teacher) {
        teacherDao.delete(teacher);
    }

    @Override
    public void deleteById(int id) {
        teacherDao.deleteById(id);
    }

    @Override
    public List<teacher> listAll() {
        return teacherDao.findAll();
    }

    @Override
    public teacher findById(int teacherId) {
        Optional<teacher> temp = teacherDao.findById(teacherId);
        return temp.get();
    }
}
