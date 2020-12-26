package com.ashokit.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entity.UserMaster;


public interface UserDetailsRepo extends JpaRepository<UserMaster, Integer> {
	
	
	          public UserMaster findByEmail(String email);
	          
	          public UserMaster findByEmailAndPassword(String email,String password);
	 
	
	        
}
