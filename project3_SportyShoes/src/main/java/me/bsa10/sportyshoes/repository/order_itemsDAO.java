package me.bsa10.sportyshoes.repository;


import me.bsa10.sportyshoes.model.order_items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface order_itemsDAO extends JpaRepository<order_items,Integer> {
}
