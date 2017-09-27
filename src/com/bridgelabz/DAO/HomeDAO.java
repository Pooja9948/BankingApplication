package com.bridgelabz.DAO;

public class HomeDAO {
	
	public static String insertCustomerDetail() {
		System.out.println("inside insertCustomerDetail");
		String query="INSERT INTO `banking_application`.`customer_detail` (`name`, `email`,`accountno`,`city`, `inputby`) VALUES (?,?,?,?,?)";
		return query;
	}

	public static String getAllCustomerDetail() {
		String query="SELECT * FROM `banking_application`.`customer_detail` WHERE city=? and inputby=?";
		return query;
	}
	public static String updateCustomerDetail(){
		System.out.println("inside updateCustomerDetail11111111111111111111");
		String query="UPDATE `banking_application`.`customer_detail` SET name=? , email=? , accountno=? ,city=? WHERE customer_detailid=?";
		return query;
	}
	public static String getCustomerDetail(){
		String query="SELECT * FROM `banking_application`.`customer_detail` WHERE customer_detailid=?";
		return query;
	}

	public static String deleteCustomer() {
		String query="DELETE FROM `banking_application`.`customer_detail` WHERE customer_detailid=?";
		return query;
	}
}
