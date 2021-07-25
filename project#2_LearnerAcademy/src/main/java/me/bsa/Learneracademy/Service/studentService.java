package me.bsa.Learneracademy.Service;

import me.bsa.Learneracademy.Model.student;


import java.util.List;

public interface studentService {


    void create (student student);

    void delete (student student);
    void deleteById(int id);

    List<student> listAll();

    student findById(int studentId);
}
