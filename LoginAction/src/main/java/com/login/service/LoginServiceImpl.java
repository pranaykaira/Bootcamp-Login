package com.login.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.dao.LoginDao;
import com.login.entity.Customer;

@Service
public class LoginServiceImpl implements LoginServiceInterface{

	@Autowired
	LoginDao dao;
	
	public String login(Customer cust) {
		// TODO Auto-generated method stub
		List<Customer> check=dao.checkforUsername(cust.getUserName());
		//	boolean check = dao.existsById(cust.getUserId());  //checking for user ID in database
		if(!check.isEmpty()) {
			List<Customer> check1=dao.checkforPassword(cust.getUserPassword());  //checking for user Password in database
			if(!check1.isEmpty())        
			return "Login Successful";   //returning message if the credentials are valid
		else
			return "Login Unsuccesful!! Please enter valid Password"; //returning message if the credentials are invalid
			}
		else
			return "Login Unsuccesful!! Please enter valid userId"; //returning message if the credentials are invalid

}
}
