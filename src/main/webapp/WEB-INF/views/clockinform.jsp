<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link href="/styles.css" rel="stylesheet" />
<meta charset="UTF-8">
<title>Clock-in</title>
</head>
<body>
<%@ include file="navbar.jsp"%>
<br>
<div class="container" align="center">	
<h1 class="btn btn-outline-primary btn-lg">TIME  TO SHOW  <br> TRUE COMMITMENT !!</h1>
 <p> ${date}</p>

</div>
<div class="container" align="center">
<h3>Please choose task from the drop down menu. <br> Then click submit to Clock-in.</h3>
<br>
<form action= "/startclock" method="post">

<td> <select class="btn btn-outline-primary" name="duty">
				<option value="">All</option>
			    <option value="meeting">Meeting</option>
			    <option value="clerical">Clerical</option>
				<option value="maintenance">Maintenance</option>
				<option value="renovation">Renovation</option>
				<option value="customer service">Customer Service</option>
				<option value="property management">Property Management</option>
			</select> 

<button class="btn btn-outline-primary">Submit</button>
</form>
</div>
<br>

<div class ="container" align="center"><a href="/">Return Home</a></div>

</body>
</html>