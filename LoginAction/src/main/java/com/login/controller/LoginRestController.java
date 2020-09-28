package com.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.entity.Customer;
import com.login.exception.NoDataFoundException;
import com.login.service.LoginServiceInterface;

@RestController
@RequestMapping("/login")
@CrossOrigin("http://localhost:4200")
public class LoginRestController {
	
	@Autowired
	LoginServiceInterface service;
	
	@GetMapping("/checkdetails")
	public ResponseEntity<String> checkLoginDetails(@RequestBody(required=false) Customer cust) throws NoDataFoundException{
		if(cust==null||cust.getUserEmail()==null||cust.getUserEmail()==""||cust.getUserPassword()==null||cust.getUserPassword()=="") {
			throw new NoDataFoundException("Incomplete input data found");
		}
		else {
			String result=service.login(cust);   //invoking the login method using ServiceInterface object
			return new ResponseEntity<String>(result,HttpStatus.OK);	
		}
			
	}
}
