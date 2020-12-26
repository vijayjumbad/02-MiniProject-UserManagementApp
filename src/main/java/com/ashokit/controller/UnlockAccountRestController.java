package com.ashokit.controller;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.ashokit.service.UserMgmtServiceImpl;

@RestController
public class UnlockAccountRestController {
	 @Autowired
	private UserMgmtServiceImpl service;
	 
	 @PostMapping("unlockAcn")
	 public ResponseEntity<String> unlockUserAccount(@RequestParam("email") String email,@RequestParam("newPwd") String newPwd){
		
		boolean unlockAccount = service.unlockAccount(email, newPwd);
		 if(unlockAccount)
		 return new ResponseEntity(unlockAccount,HttpStatus.CREATED);
		 else
			 return new ResponseEntity(new Error(),HttpStatus.CONFLICT);
	 }

}
