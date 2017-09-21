package com.bridgelabz.bankingapplication;

import java.sql.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Home extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response){
		HttpSession session = request.getSession(true);
		String id = session.getAttribute("id").toString();
		String name= request.getParameter("name");
		String email= request.getParameter("email");
		String accountno= request.getParameter("accountno");
		String city= request.getParameter("city");
		
		
		
	}
}
