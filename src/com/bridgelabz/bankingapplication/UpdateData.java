package com.bridgelabz.bankingapplication;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateData extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		int id= Integer.parseInt(request.getParameter("id"));
		System.out.println("id : "+id);
		PreparedStatement preparestatement=null;
		Connection connection=null;
		//String selectquery=HomeDAO.updateUserDetail();
	}
}
