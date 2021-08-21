package me.bsa.Learneracademy.Service.impl;

import me.bsa.Learneracademy.Model.student;
import me.bsa.Learneracademy.Repository.studentDao;
import me.bsa.Learneracademy.Service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class studentServiceImpl implements studentService {

    @Autowired
    private studentDao studentDao;

    @Override
    public void create(student student) {
        studentDao.save(student);
    }

    @Override
    public void delete(student student) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<student> listAll() {
        return studentDao.findAll();
    }

    @Override
    public student findById(int studentId) {
        Optional<student> student = studentDao.findById(studentId);
        return student.get();
    }
}
