package me.bsa10.sportyshoes.repository;

import me.bsa10.sportyshoes.model.admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface adminDAO extends JpaRepository<admin,Integer> {
}
