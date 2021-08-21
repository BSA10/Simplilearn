package me.bsa10.sportyshoes.repository;


import me.bsa10.sportyshoes.model.order_details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface order_detailsDAO extends JpaRepository<order_details,Integer> {
}
