package me.bsa.Learneracademy.Repository;

import me.bsa.Learneracademy.Model.student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentDao extends JpaRepository<student,Integer> {
}
