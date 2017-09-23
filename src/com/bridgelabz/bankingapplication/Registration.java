package com.bridgelabz.bankingapplication;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Registration")
public class Registration extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		PreparedStatement preparestatement=null;
		Connection connection=null;
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
	    String insertquery=BankDAO.insertUserDetail();
	    try {
	    	connection=BankDAO.getConnection();
	    	preparestatement = connection.prepareStatement(insertquery);
	        String name = request.getParameter("name");
	        String email= request.getParameter("email");
		    String password= request.getParameter("password");
		    String mobileno= request.getParameter("mobileno");
	        UserDetails userdetail=new UserDetails();	
	        userdetail.setName(name);
	        userdetail.setEmail(email);
	        userdetail.setPassword(password);
	        userdetail.setMobileno(mobileno);
	        preparestatement.setString(1, userdetail.getName());
	        preparestatement.setString(2, userdetail.getEmail());
	        preparestatement.setString(3, userdetail.getPassword());
	        preparestatement.setString(4, userdetail.getMobileno());
	        
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
	    RequestDispatcher dispatcher= request.getRequestDispatcher("login.jsp");
	    dispatcher.include(request, response);
	}
}
