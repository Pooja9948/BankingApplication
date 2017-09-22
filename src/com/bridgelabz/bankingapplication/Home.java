package com.bridgelabz.bankingapplication;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Home extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		System.out.println("servlet inside ");
		HttpSession session = request.getSession();
		String id = session.getAttribute("id").toString();
		System.out.println(id+" id8324");
		PreparedStatement preparestatement=null;
		Connection connection=null;
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
	    String insertquery=HomeDAO.insertCustomerDetail();
	    try {
	    	connection=BankDAO.getConnection();
	    	preparestatement = connection.prepareStatement(insertquery);
			String name= request.getParameter("name");
			String email= request.getParameter("email");
			String accountno= request.getParameter("accountno");
			String city= request.getParameter("city");
			System.out.println(name+" "+email+" "+accountno+" "+city+" "+id);
			CustomerDetail customerdetail = new CustomerDetail();
			customerdetail.setName(name);
			customerdetail.setEmail(email);
			customerdetail.setAccountno(accountno);
			customerdetail.setCity(city);
			customerdetail.setInputby(id);
			preparestatement.setString(1, customerdetail.getName());
	        preparestatement.setString(2, customerdetail.getEmail());
	        preparestatement.setString(3, customerdetail.getAccountno());
	        preparestatement.setString(4, customerdetail.getCity());
	        preparestatement.setString(5, customerdetail.getInputby());
	        
	        preparestatement.executeUpdate();
	        
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
	    System.out.println("jefkwrerge");
	    RequestDispatcher dispatcher= request.getRequestDispatcher("home.html");
	    dispatcher.forward(request, response);
	}
}
