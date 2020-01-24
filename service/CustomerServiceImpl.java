package com.robomq.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.robomq.dao.DBConnection;
import com.robomq.pojo.Customer;

public class CustomerServiceImpl implements CustomerService {
	Connection con;
	PreparedStatement pre;
	int ra;
	ResultSet res;
	boolean flag=false;
	public CustomerServiceImpl()
	{
		con=DBConnection.getConnection();
	}

	//Register a New Customer
	public boolean createCustomer(Customer c)
	{
		try {
			
			pre=con.prepareStatement("insert into Customer11 values(?,?,?,?,?)");
			pre.setInt(1,c.getCustomerId());
			pre.setString(2,c.getName());
			pre.setString(3,c.getEmail());
			pre.setString(4,c.getAddress());
			pre.setString(5,c.getMobileno());
			
			ra=pre.executeUpdate();
			if(ra>0)
					flag=true;
			else
				flag=false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public ResultSet displayCustomer(int cid)
	{
		try {
			pre=con.prepareStatement("select * from Customer11 where cid=?");
			pre.setInt(1,cid);
			res=pre.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	public boolean updateCustomer(Customer c)
	{
		try {
			
			pre=con.prepareStatement("update Customer11 set address=?,email=?,mobileno=? where idcustomer=?");
			pre.setString(1,c.getAddress());
			pre.setString(2,c.getEmail());
			pre.setString(3,c.getMobileno());
			pre.setInt(4,c.getCustomerId());
			
			ra=pre.executeUpdate();
			if(ra>0)
					flag=true;
			else
				flag=false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
		}

	@Override
	public boolean deleteCustomer(Customer c) {
		// TODO Auto-generated method stub
		try {
			
			pre=con.prepareStatement("delete from Customer11 where idcustomer=?");
			pre.setInt(1,c.getCustomerId());
			
			ra=pre.executeUpdate();
			if(ra>0)
					flag=true;
			else
				flag=false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
		
	}

	public ResultSet displayCustomer()
	{
		try {
			pre=con.prepareStatement("select * from Customer11");
			res=pre.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public ResultSet validateCustomer(int id, String name) {
		try {
			pre=con.prepareStatement("select * from Customer11 where idcustomer=? and name=?");
			pre.setInt(1,id);
			pre.setString(2, name);
			res=pre.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}


}
