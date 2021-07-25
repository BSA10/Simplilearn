package me.bsa.Learneracademy.Service;


import me.bsa.Learneracademy.Model.teacher;

import java.util.List;

public interface teacherService {

    void create (teacher teacher);

    void delete (teacher teacher);
    void deleteById(int id);

    List<teacher> listAll();

    teacher findById(int teacherId);
}
