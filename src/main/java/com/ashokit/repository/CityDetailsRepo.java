package com.ashokit.repository;



import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ashokit.entity.CityMaster;

public interface CityDetailsRepo extends JpaRepository<CityMaster, Integer> {
	
	public List<CityMaster> findByStateId(Integer stateId);
	
	        
}
