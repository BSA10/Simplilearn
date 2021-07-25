package me.bsa.Learneracademy.Service;


import me.bsa.Learneracademy.Model.subject;

import java.util.List;

public interface subjectService {

    void create (subject subject);

    void delete (subject subject);
    void deleteById(int id);

    List<subject> listAll();

    subject findById(int id);
}
