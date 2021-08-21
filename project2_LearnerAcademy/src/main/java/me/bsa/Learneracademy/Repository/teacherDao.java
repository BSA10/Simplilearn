package me.bsa.Learneracademy.Repository;

import me.bsa.Learneracademy.Model.teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface teacherDao extends JpaRepository<teacher,Integer> {
}
