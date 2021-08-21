package me.bsa.Learneracademy.Repository;

import me.bsa.Learneracademy.Model.subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface subjectDao extends JpaRepository<subject,Integer> {
}
