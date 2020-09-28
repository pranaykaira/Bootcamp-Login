package com.login.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.login.entity.Customer;

@Repository
public interface LoginDao extends JpaRepository<Customer, String>{

	@Query(value="select * from customer where user_password=?1",nativeQuery=true) //Retreive details of customer using userPassword
	List<Customer> checkforPassword(String userPassword);
	
	@Query(value="select * from customer where user_email=?1",nativeQuery=true) //Retreive details of customer using userPassword
	List<Customer> checkforUseremail(String userEmail);	 

}
