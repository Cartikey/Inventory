package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.app.entities.User;

public interface IUserDao extends JpaRepository<User, Long> {
	// User validateUser(String email, String password);
	// custom finder method
	Optional<User> findByEmailAndPassword(String em, String pass);

}
