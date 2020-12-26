package com.ashokit.service;

import java.util.Map;

import com.ashokit.entity.UserMaster;

public interface IUserMgmtService {
	
	public Map<Integer, String> findCountries();
	
	public Map<Integer,String> findstates(Integer countryId);
	
	public Map<Integer,String> findCities(Integer stateId);
	
	public boolean isEmailUnique(String emailId);
	
	public boolean saveUserDetails(UserMaster um);
	
	//login functionality
	public String checkLogin(String email,String password);
	
	public boolean isTempPwdValid(String email,String tempPwd);
	
	public boolean unlockAccount(String email,String newPwd);
	
	public String forgotPwd(String email);
	
	

}
