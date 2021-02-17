package com.entity;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService {

	@Autowired
	UserRepository rep;
	
	@Autowired
	ProductRepository repp;
	
	@Autowired
	IteamRepository repiteam;
	
	@Transactional
	public byte[] loadimage(String productname) {
	return	repp.findByProductname(productname).get(0).getImage();
		//return repp.findByProductname(productname).getImage();
	}
	
	@Transactional
	public List<Product> getrandomproducts() {
		return repp.findrandProducts();
	}
	

	@Transactional
	public List<Iteam> getrandomiteams() {
		return repiteam.findrandIteams();

	}
	
	@Transactional
	public List<Product> findproducts(String productname) {
		return repp.findByProductname(productname);
	}

	@Transactional
	public List<Iteam> finditemas(String iteamName){
		return repiteam.findByItemname(iteamName);
	}
	
	@Transactional	
	public User createUser(User user) {
		return rep.save(user);
	}
	
	@Transactional
	public User findUserById(long id) {
		return rep.findById(id).get();
	}
	
	@Transactional
	public List<User> findAll() {
		return rep.findAll();
		
	}
	
	@Transactional
	public Iteam finditeam(String selleremail , int id) {
		return repiteam.findBySellerandIteamname(selleremail, id);
		
	}
	
	@Transactional
	public void updatevalue(String seller , String price , String itemname , String id){
	 BigDecimal p = new BigDecimal(price);
	 Integer.valueOf(id);
	 
	 Iteam iteam =repiteam.findBySellerandIteamname(seller, Integer.valueOf(id));
	 iteam.setPrice(p);
		
	}
	
	@Transactional
	public void changeActivationValue(String email){
		
	User user=	rep.findByEmail(email);
	user.setActive(1);
	}
	
	@Transactional
	public User finduserbyemailaddress(String email) {
		return rep.findByEmail(email); 
	}
	
	@Transactional
	public User checkIfExist(String email) {
		return rep.findByEmail(email); 
	}
	
	@Transactional
	public boolean checkIfAlreadyActive(String email) {
		return rep.checkIfActive(email);
	}
}
