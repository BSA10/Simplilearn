package me.bsa10.sportyshoes.repository;

import me.bsa10.sportyshoes.model.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productDAO extends JpaRepository<product,Integer> {
}
