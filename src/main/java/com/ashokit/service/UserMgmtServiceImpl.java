package com.ashokit.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.entity.CityMaster;
import com.ashokit.entity.CountryMaster;
import com.ashokit.entity.StateMaster;
import com.ashokit.entity.UserMaster;
import com.ashokit.repository.CityDetailsRepo;
import com.ashokit.repository.CountryDetailsRepo;
import com.ashokit.repository.StateDetailsRepo;
import com.ashokit.repository.UserDetailsRepo;

@Service("userService")
public class UserMgmtServiceImpl implements IUserMgmtService {

	@Autowired
	private CountryDetailsRepo countryRepo;

	@Autowired
	private StateDetailsRepo stateRepo;

	@Autowired
	private CityDetailsRepo cityRepo;

	@Autowired
	private UserDetailsRepo userRepo;

	@Override
	public Map<Integer, String> findCountries() {
		List<CountryMaster> findCountry = countryRepo.findAll();
		Map<Integer, String> countries = new HashMap();
		findCountry.forEach(country -> {
			countries.put(country.getCountryId(), country.getCountryName());
		});
		return countries;
	}

	@Override
	public Map<Integer, String> findstates(Integer countryId) {

		List<StateMaster> stateList = stateRepo.findByCountryId(countryId);
		Map<Integer, String> states = new HashMap();
		stateList.forEach(s -> {
			states.put(s.getStateId(), s.getStateName());
		});

		return states;
	}

	@Override
	public Map<Integer, String> findCities(Integer stateId) {
		List<CityMaster> cityList = cityRepo.findByStateId(stateId);
		Map<Integer, String> cities = new HashMap();
		cityList.forEach(city -> {
			cities.put(city.getCityId(), city.getCityName());
		});

		return cities;
	}

	@Override
	public boolean isEmailUnique(String emailId) {
		UserMaster userdetails = userRepo.findByEmail(emailId);
		return userdetails.getRegId()==null?true:false;
	}

	@Override
	public boolean saveUserDetails(UserMaster um) {
		um.setPassword(generatePassword());
		um.setAcnStatus("LOCKED");
		UserMaster user = userRepo.save(um);
		return user.getRegId()!=null;
	}

	public String generatePassword() {
		char[] password = new char[5];
		String alphanumeric = "abcdghetyi12345652";
		Random random = new Random();
		for (int i = 0; i <= alphanumeric.length(); i++) {

			password[i] = alphanumeric.charAt(random.nextInt(alphanumeric.length()));

		}
		System.out.println(password.toString());
		return password.toString();
	}

	@Override
	public String checkLogin(String email, String password) {
		UserMaster user = userRepo.findByEmailAndPassword(email, password);
		if (user != null) {
			if (user.getAcnStatus().equals("LOCKED"))
				return " Account is locked";
			else
				return "login successful";
		}

		return "invalid credential";
	}

	@Override
	public boolean isTempPwdValid(String email, String tempPwd) {
		 UserMaster user  = userRepo.findByEmailAndPassword(email, tempPwd);
		
		return user.getRegId()!=null;
	}

	@Override
	public boolean unlockAccount(String email, String newPwd) {
             UserMaster user = userRepo.findByEmail(email);
             user.setPassword(newPwd);
             user.setAcnStatus("UNLOCKED");
             try {
              UserMaster usermaster = userRepo.save(user);
              return true;
             }catch(Exception e)
             {
            	 e.printStackTrace();
		return false;
	}
	}
	@Override
	public String forgotPwd(String email) {
           UserMaster  usermaster= userRepo.findByEmail(email);
          if(usermaster!=null) {
		return usermaster.getPassword();
          }else {
        	  return null;
          }
	}

}
