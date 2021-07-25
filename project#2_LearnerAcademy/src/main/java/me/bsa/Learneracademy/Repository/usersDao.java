package me.bsa.Learneracademy.Repository;

import me.bsa.Learneracademy.Model.users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface usersDao extends JpaRepository<users,Integer> {
}
