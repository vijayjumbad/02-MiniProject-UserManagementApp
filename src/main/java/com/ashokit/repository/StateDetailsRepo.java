package com.ashokit.repository;





import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entity.StateMaster;



public interface StateDetailsRepo extends JpaRepository<StateMaster, Integer> {
	
	public List<StateMaster> findByCountryId(Integer countryId);
	
	        
}
