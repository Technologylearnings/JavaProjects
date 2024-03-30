package repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{

	Optional<User> findByUsrname(String username);


}
