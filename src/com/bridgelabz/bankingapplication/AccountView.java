package com.bridgelabz.bankingapplication;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AccountView extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String city= request.getParameter("city");
		HttpSession session = request.getSession();
		String id = session.getAttribute("id").toString();
		System.out.println(id+" id8324");
		PreparedStatement preparestatement=null;
		Connection connection=null;
		ResultSet resultset=null;
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
	    String selectquery=HomeDAO.getUserDetail();
	    String name="";
	    String accountno="";
	    String emailid="";
	    try {
	    	connection=BankDAO.getConnection();
	    	preparestatement = connection.prepareStatement(selectquery);
	    	CustomerDetail customerdetail = new CustomerDetail();
	    	customerdetail.setCity(city);
			customerdetail.setInputby(id);
			preparestatement.setString(1, customerdetail.getCity());
	        preparestatement.setString(2, customerdetail.getInputby());
	        resultset=preparestatement.executeQuery();
	        while(resultset.next()){
	        	name=resultset.getString(1);
	        	accountno=resultset.getString(2);
	        	emailid=resultset.getString(3);
	       }
	    }catch(SQLException se) {
	         se.printStackTrace();
	      } finally {
	         try {
	            if(preparestatement!=null)
	            	preparestatement.close();
	            
	         }catch(SQLException se2) {
	        	 se2.printStackTrace();
	         }
	         try {
	            if(connection!=null)
	            connection.close();
	         } catch(SQLException se) {
	            se.printStackTrace();
	         }
	      }
	}
}
