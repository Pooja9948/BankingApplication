package com.bridgelabz.bankingapplication;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Home extends HttpServlet{
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		System.out.println(" inside home class");
		String customer_detailid= request.getParameter("id");
		
		String name="";
		String email="";
		String accountno="";
		String city="";
		System.out.println("customer_detailid : "+customer_detailid);
		if(customer_detailid!=null){
			System.out.println("inside if");
			//String name= request.getParameter("name");
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			ResultSet resultset=null;
			System.out.println("inside update data class");
			//String customer_detailid= request.getParameter("id");
			System.out.println("id : "+customer_detailid);
			PreparedStatement preparestatement=null;
			Connection connection=null;
			String getquery=HomeDAO.getCustomerDetail();
			
			try {
		    	connection=BankDAO.getConnection();
		    	preparestatement = connection.prepareStatement(getquery);
		    	CustomerDetail customerdetail = new CustomerDetail();
		    	customerdetail.setId(customer_detailid);
		    	preparestatement.setString(1, customerdetail.getId());
		    	resultset=preparestatement.executeQuery();
		    	if(resultset.next()){
		        	name=resultset.getString(2);
		        	email=resultset.getString(3);
		        	accountno=resultset.getString(4);
		        	city=resultset.getString(5);
		        	System.out.println("name "+name+"email "+email+"accountno "+accountno+"city "+city);
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
		}else{
			System.out.println("inside else");
			HttpSession session = request.getSession();
			String id = session.getAttribute("id").toString();
			//System.out.println(id+" id8324");
			PreparedStatement preparestatement=null;
			Connection connection=null;
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
		    String insertquery=HomeDAO.insertCustomerDetail();
		    try {
		    	connection=BankDAO.getConnection();
		    	preparestatement = connection.prepareStatement(insertquery);
				 name= request.getParameter("name");
				 email= request.getParameter("email");
				 accountno= request.getParameter("accountno");
				 city= request.getParameter("city");
				//System.out.println(name+" "+email+" "+accountno+" "+city+" "+id);
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
			}
	    //System.out.println("jefkwrerge");
		request.setAttribute("name", name);
		System.out.println("Home.Java :: :"+request.getAttribute("name") );
		
		request.setAttribute("email", email);
		System.out.println("Home.Java email :: :"+request.getAttribute("email") );
		
		request.setAttribute("accountno", accountno);
		request.setAttribute("city", city);
		
		JSONObject obj=new JSONObject();
		obj.put("name", name);
		obj.put("email", email);
		obj.put("accountno", accountno);
		obj.put("city", city);
		
		JSONArray ary=new JSONArray();
		ary.add(obj);
		
		
		System.out.println(obj.toJSONString());
		
		
		
		
		
	    RequestDispatcher dispatcher= request.getRequestDispatcher("home.jsp");
	    dispatcher.forward(request, response);
	}
}
