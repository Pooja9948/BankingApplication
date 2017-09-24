<%@page import="java.util.ArrayList"%>
<%@page import="com.bridgelabz.bankingapplication.CustomerDetail"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/home.css">
</head>
<body>
<%HttpSession session1=request.getSession();
   String sting=(String)session1.getAttribute("uname");
   if(sting==""){ 
	   RequestDispatcher dispatcher= request.getRequestDispatcher("login.jsp");
	    dispatcher.forward(request, response);
	}else {%>

	
	<div class="well">
		<div style="background-color: cyan; font-size: 40px" align="center">
			Welcome to Banking Application</div>
		<div style="background-color: cyan; font-size: 40px" align="right">
		<form action="Logout">
			<input type="submit" value="Logout" class="btn btn-primary" >
			</form>
		</div>
	</div>
	
	<div class="container">
		<div class="x">
			<button type="button" data-toggle="modal" data-target="#cityModal"
				onclick="cityData('bangalore')" class="btn btn-primary btn-lg">Bangalore</button>
			<button type="button" data-toggle="modal" data-target="#cityModal"
				onclick="cityData('mumbai')" class="btn btn-primary btn-lg">Mumbai</button>
			<button type="button" data-toggle="modal" data-target="#cityModal"
				onclick="cityData('delhi')" class="btn btn-primary btn-lg">Delhi</button>
		</div>
		<h1><%=session.getAttribute("uname") %></h1>
		<!-- Modal -->
		<div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Account Details</h4>
					</div>

					<div class="modal-body">
						<form class="form" action="Home" method="get">
							<!-- put if condition for id  -->
							<div class="container">
								<div class="row">
									<div class="control-group">
										<div class="controls">
											<label class="col-sm-3">Name</label> <input id="name"
												name="name" type="text" placeholder="" class="input-xlarge"
												required="">

										</div>
										<div class="controls">
											<label class="col-sm-3">EmailId</label> <input id="email"
												name="email" type="email" placeholder=""
												class="input-xlarge" required="">

										</div>
										<div class="controls">
											<label class="col-sm-3">Account No</label> <input
												id="accountno" name="accountno" type="text" placeholder=""
												class="input-xlarge" required="">

										</div>
										<div class="controls">
											<label class="col-sm-3">City</label> <select id="city"
												name="city" class="col-sm-2">
												<option value="bangalore">Bangalore</option>
												<option value="mumbai">Mumbai</option>
												<option value="delhi">Delhi</option>
											</select>
										</div>
									</div>
								</div>
							</div>
							<div class="modal-footer">
								<input type="submit" name="submit" id="submit"
									class="btn btn-info data-dismiss="modal">
								<button type="close" name="close" id="close" value="Close"
									class="btn btn-info data-dismiss="modal">Close</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		
		
		
		
		<div class="modal fade" id="cityModal" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header" id="city-title">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Customer Details</h4>
					</div>

					<div class="modal-body" id="details-table"></div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
		
	</div>
	<%} %>
</body>
<footer>
<button type="button" id="div1" class="btn btn-success"
	style="margin-top: 200px; float: right" data-toggle="modal"
	data-target="#myModal">Add</button>
</footer>




<script type="text/javascript">
	$(document).ready(function() {
		alert("inside function");
		var city = "";
		var id = "";
		console.log("Starting javascript");
	});

	function cityData(city) {
		console.log("inside javascript");
		$.ajax({
			type : 'POST',
			url : 'AccountView',
			data : {
				city : city
			},
			success : function(result) {
				console.log("ajax success");
				console.log(result);
				$('#details-table').html(result);
				$('#body-of-modal').html(result);
				$('#cityModal').modal('show');
			}
		});
	}
	function updateAccount(id) {
		console.log("inside javascript");
		$.ajax({
			type : 'POST',
			url : 'AccountView',
			data : {
				city : city
			},
			success : function(result) {
				console.log("ajax success");
				console.log(result);
				$('#details-table').html(result);
				$('#body-of-modal').html(result);
				$('#myModal').modal('show');
			}
		});
	}
</script>
</html>