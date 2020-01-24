package com.robomq.service;

import java.sql.ResultSet;

import com.robomq.pojo.Customer;

public interface CustomerService {
	public boolean createCustomer(Customer c);
	public ResultSet displayCustomer(int cid);
	public boolean updateCustomer(Customer c);
	public boolean deleteCustomer(Customer c);
	public ResultSet displayCustomer();
	public ResultSet validateCustomer(int id, String name);
}

 

