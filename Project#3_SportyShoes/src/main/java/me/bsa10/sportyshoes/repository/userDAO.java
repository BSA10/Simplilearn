package me.bsa10.sportyshoes.repository;


import me.bsa10.sportyshoes.model.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userDAO extends JpaRepository<user,Integer> {

    user findByUsername(String username);
}
