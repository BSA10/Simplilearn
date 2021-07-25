package me.bsa.Learneracademy.Service;

import me.bsa.Learneracademy.Model.classes;

import java.util.List;

public interface classesService {

    void create (classes classes);

    void delete (classes classes);
    void deleteById(int id);

    List<classes> listAll();

    classes findById(int class_id);



}
