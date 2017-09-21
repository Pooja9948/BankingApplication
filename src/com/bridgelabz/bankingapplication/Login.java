package com.bridgelabz.bankingapplication;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("hrtgefadqhfd");
		PreparedStatement preparestatement=null;
		Connection connection=null;
		ResultSet resultset=null;
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
	    String selectquery=BankDAO.checkUserDetail();
		String email= request.getParameter("email");
		System.out.println(email);
	    String password= request.getParameter("password");
	    int value=1;
	    String uname="";
	    int id=0;
	    try {
	    	connection=BankDAO.getConnection();
	    	preparestatement = connection.prepareStatement(selectquery);
	    	UserDetails userdetail=new UserDetails();
	    	userdetail.setEmail(email);
	    	userdetail.setPassword(password);
	    	preparestatement.setString(1, userdetail.getEmail());
	        preparestatement.setString(2, userdetail.getPassword());
	        resultset=preparestatement.executeQuery();
	        if(resultset.next()){
	        	id=resultset.getInt(1);
	        	uname=resultset.getString(2);
	        	value++;
	        }else{
	        	value--;
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
	    
	    
	    if(value==2){
		    RequestDispatcher dispatcher= request.getRequestDispatcher("home.html");
		    dispatcher.forward(request, response);
		    HttpSession session = request.getSession(true);
		    session.setAttribute("uname", uname);
		    session.setAttribute("id", id);
	    }else{
	    	RequestDispatcher dispatcher= request.getRequestDispatcher("Login.html");
		    dispatcher.forward(request, response);
	    }
	}
}
