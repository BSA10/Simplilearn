package me.bsa10.sportyshoes.repository;

import me.bsa10.sportyshoes.model.cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface cartDAO extends JpaRepository<cart,Integer> {
}
