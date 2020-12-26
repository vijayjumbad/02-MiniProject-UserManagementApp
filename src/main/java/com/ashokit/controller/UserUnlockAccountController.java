package com.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.entity.UserMaster;
import com.ashokit.service.UserMgmtServiceImpl;

@RestController
public class UserUnlockAccountController {
	 @Autowired
	private UserMgmtServiceImpl service;
	 
	 @PostMapping("unlockAcn")
	 public ResponseEntity<UserMaster> unlockUserAccount(@RequestParam("email") String email,@RequestParam("password") String password){
		
		 //user service
		 boolean unlockAccount = service.unlockAccount(email, password);
		 
		 return new ResponseEntity<UserMaster>(HttpStatus.CREATED);
		 
	 }

}
