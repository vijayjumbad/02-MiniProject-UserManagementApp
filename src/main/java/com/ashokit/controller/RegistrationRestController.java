package com.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.entity.UserMaster;
import com.ashokit.service.UserMgmtServiceImpl;

@RestController
public class RegistrationRestController {
	 @Autowired
	private UserMgmtServiceImpl service;
	
	 @GetMapping("getForm")
	public ResponseEntity<UserMaster> saveRegistrationForm(@RequestBody UserMaster usermaster)
	{
		 //user service
		 boolean UserDetails = service.saveUserDetails(usermaster);
		 
		return new ResponseEntity<UserMaster>(usermaster, HttpStatus.OK);
		
	}
}
