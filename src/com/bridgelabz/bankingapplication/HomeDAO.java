package com.bridgelabz.bankingapplication;

public class HomeDAO {
	
	public static String insertCustomerDetail() {
		System.out.println("inside insertCustomerDetail");
		String query="INSERT INTO `banking_application`.`customer_detail` (`name`, `email`,`accountno`,`city`, `inputby`) VALUES (?,?,?,?,?)";
		return query;
	}

	public static String getUserDetail() {
		String query="SELECT * FROM `banking_application`.`customer_detail` WHERE city=? and inputby=?";
		return query;
	}
}
