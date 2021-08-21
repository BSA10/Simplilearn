package me.bsa10.sportyshoes.repository;

import me.bsa10.sportyshoes.model.category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface categoryDAO extends JpaRepository<category , Integer> {
}
