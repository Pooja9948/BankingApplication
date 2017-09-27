package com.bridgelabz.controller;

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

import com.bridgelabz.DAO.BankDAO;
import com.bridgelabz.DAO.HomeDAO;
import com.bridgelabz.pojo.CustomerDetail;

public class Home extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println(" inside home class");
		String customer_detailid = request.getParameter("id");

		String name = "";
		String email = "";
		String accountno = "";
		String city = "";
		System.out.println("customer_detailid : " + customer_detailid);
		if (customer_detailid != null) {
			System.out.println("inside if");
			// String name= request.getParameter("name");
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			ResultSet resultset = null;
			System.out.println("inside update data class");
			// String customer_detailid= request.getParameter("id");
			System.out.println("id : " + customer_detailid);
			PreparedStatement preparestatement = null;
			Connection connection = null;
			String getquery = HomeDAO.getCustomerDetail();

			try {
				connection = BankDAO.getConnection();
				preparestatement = connection.prepareStatement(getquery);
				CustomerDetail customerdetail = new CustomerDetail();
				customerdetail.setId(customer_detailid);
				preparestatement.setString(1, customerdetail.getId());
				resultset = preparestatement.executeQuery();
				if (resultset.next()) {
					name = resultset.getString(2);
					email = resultset.getString(3);
					accountno = resultset.getString(4);
					city = resultset.getString(5);
					System.out.println("name " + name + "email " + email + "accountno " + accountno + "city " + city);
					JSONObject obj = updateAccount(Integer.parseInt(customer_detailid));
					out.println(obj.toJSONString());
					System.out.println("---home--->" + obj.get("name"));
					//Home.editAccount(Integer.parseInt(customer_detailid));
					
				}
			} catch (SQLException se) {
				se.printStackTrace();
			} finally {
				try {
					if (preparestatement != null)
						preparestatement.close();

				} catch (SQLException se2) {
					se2.printStackTrace();
				}
				try {
					if (connection != null)
						connection.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
		} else {
			System.out.println("inside else");
			HttpSession session = request.getSession();
			String id = session.getAttribute("id").toString();
			// System.out.println(id+" id8324");
			PreparedStatement preparestatement = null;
			Connection connection = null;
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			String insertquery = HomeDAO.insertCustomerDetail();
			try {
				connection = BankDAO.getConnection();
				preparestatement = connection.prepareStatement(insertquery);
				name = request.getParameter("name");
				email = request.getParameter("email");
				accountno = request.getParameter("accountno");
				city = request.getParameter("city");
				// System.out.println(name+" "+email+" "+accountno+" "+city+"
				// "+id);
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

			} catch (SQLException se) {
				se.printStackTrace();
			} finally {
				try {
					if (preparestatement != null)
						preparestatement.close();

				} catch (SQLException se2) {
					se2.printStackTrace();
				}
				try {
					if (connection != null)
						connection.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
			System.out.println(request);
		}
		request.setAttribute("name", name);
		request.getAttribute("name");

		request.setAttribute("email", email);
		request.getAttribute("email");

		request.setAttribute("accountno", accountno);
		request.setAttribute("city", city);
		
		
		
	}

	public static JSONObject updateAccount(int customer_detailid) {
		JSONObject obj = new JSONObject();
		PreparedStatement preparetatement = null;
		try {
			Connection con = BankDAO.getConnection();
			preparetatement = con.prepareStatement(
					"SELECT * FROM `banking_application`.`customer_detail` WHERE customer_detailid=?");
			preparetatement.setInt(1, customer_detailid);
			ResultSet rs = preparetatement.executeQuery();
			System.out.println("before rs");
			if (rs.next()) {
				System.out.println("after rs");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String city = rs.getString("city");
				String accountno = rs.getString("accountno");
				System.out.println("sids log " + name + email + city);
				obj.put("name", name);
				obj.put("email", email);
				obj.put("city", city);
				obj.put("accountno", accountno);
				JSONArray array = new JSONArray();
				array.add(obj);
				preparetatement.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return obj;
	}

	/*public static void editAccount(int customer_detailid) {
		try {
			Connection con = BankDAO.getConnection();
			String query = "UPDATE `banking_application`.`customer_detail` SET name=? , email=? , accountno=? ,city=? WHERE customer_detailid=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(5, customer_detailid);
			CustomerDetail customerdetail = new CustomerDetail();
			pstmt.setString(1, customerdetail.getName());
			pstmt.setString(2, customerdetail.getEmail());
			pstmt.setString(3, customerdetail.getCity());
			pstmt.setString(4, customerdetail.getAccountno());
			pstmt.executeUpdate();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}*/
	
	
	
	
	
	
}
