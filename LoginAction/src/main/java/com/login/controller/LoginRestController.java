package com.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.entity.Customer;
import com.login.exception.NoDataFoundException;
import com.login.service.LoginServiceInterface;

@RestController
@RequestMapping("/login")

public class LoginRestController {
	
	@Autowired
	LoginServiceInterface service;
	
	@GetMapping("/checkdetails")
	public String checkLoginDetails(@RequestBody(required=false) Customer cust) throws NoDataFoundException{
		if(cust!=null) {
		String result=service.login(cust);   //invoking the login method using ServiceInterface object
		return result;	
		}
		else 
			throw new NoDataFoundException("No input data found");
	}
}
