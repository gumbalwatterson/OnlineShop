package com.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public User findByName(String name);
	public User findByEmail(String email);
	
	@Query("select u.active from User u where u.email = ?1")
	public boolean checkIfActive(String email);
}
