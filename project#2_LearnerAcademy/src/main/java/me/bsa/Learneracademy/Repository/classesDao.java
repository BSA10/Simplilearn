package me.bsa.Learneracademy.Repository;

import me.bsa.Learneracademy.Model.classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface classesDao extends JpaRepository<classes,Integer> {



}
