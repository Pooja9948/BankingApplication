package com.bridgelabz.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Random;

public class BankDAO {
	
	public static Connection getConnection(){
		Connection connection=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
	        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
		}catch(ClassNotFoundException | SQLException se) {
	         se.printStackTrace();
	      }
	   return connection;  
	}

	public static String insertUserDetail() {
		String query="INSERT INTO `banking_application`.`user_detail` (`name`, `email`, `password`, `mobileno`) VALUES (?,?,?,?)";
		return query;
	}

	public static String checkUserDetail() {
		String query="SELECT * FROM `banking_application`.`user_detail` WHERE email=? and password=?";
		return query;
	}
	 
	public static int hello(){
		Random r = new Random();
		int n = r.nextInt(10);
		System.out.println(n);
		return n;
	}
}
