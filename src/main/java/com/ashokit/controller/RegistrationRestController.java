package com.ashokit.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.entity.UserMaster;
import com.ashokit.service.UserMgmtServiceImpl;

@RestController
public class RegistrationRestController {
	@Autowired
	private UserMgmtServiceImpl service;

	@GetMapping("/getAllCounties")
	public ResponseEntity<Map<Integer, String>> handleCountrySelectBox() {
		//use service
		Map<Integer, String> findCountries = service.findCountries();
		return new ResponseEntity<Map<Integer, String>>(findCountries, HttpStatus.OK);

	}

	@GetMapping("/getStates")
	public ResponseEntity<Map<Integer, String>> handlestatesSelectBox(@RequestParam("countryId") Integer countryId) {
		//use service
		Map<Integer, String> findstates = service.findstates(countryId);

		return new ResponseEntity<Map<Integer, String>>(findstates, HttpStatus.OK);

	}

	@GetMapping("/getCities")
	public ResponseEntity<Map<Integer, String>> handleCitiesSelectBox(@RequestParam("cityId") Integer stateId) {
		//use service
		Map<Integer, String> findCities = service.findCities(stateId);
		return new ResponseEntity<Map<Integer, String>>(findCities, HttpStatus.OK);
	}

	@PostMapping("/registrationForm")
	public ResponseEntity<String> saveRegistrationForm(@RequestBody UserMaster usermaster) {
		//user service
		boolean UserDetails = service.saveUserDetails(usermaster);

		return new ResponseEntity<String>(
				usermaster != null ? "user registration successful" : "user registration successful",
				HttpStatus.CREATED);

	}
}
