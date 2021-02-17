package com.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IteamRepository extends JpaRepository<Iteam, Integer> {

	public List<Iteam> findByItemname(String iteamName);
	
	@Query("select i from Iteam i")
	public List<Iteam> findrandIteams();
	
	@Query("SELECT i From Iteam i Where i.seller=?1 and i.id=?2")
	public Iteam findBySellerandIteamname(String selleremail , int id);
	
	public List<Iteam> findBySeller(String seller);
}
