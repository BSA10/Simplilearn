package me.bsa10.sportyshoes.repository;


import me.bsa10.sportyshoes.model.user_address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface user_addressDAO extends JpaRepository<user_address,Integer> {
}
