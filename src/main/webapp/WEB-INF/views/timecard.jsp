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
<title>View Time Card</title>
</head>
<body>
<%@ include file="navbar.jsp"%>



<div class="container">
		<h1>Associate Time Card</h1>
		<table class="table">
			<thead>
				<tr>
					<th>Start <br> Date/Time</th><th>End <br>Date/Time</th><th>Duty <br> Performed</th><th>Time Worked</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="time" items="${ timestamps}">
				<%-- <c:if test = "${time.start.contains('') && time.end.contains(' ') }" >--%>
				
				<tr>
					<td>${time.start}</td>
					<td> ${time.end} </td>
				    <td> ${time.duty} </td>
				  <td> ${time.hours} </td>
				     <td> ${total} </td>
				     <td> <a href="/delete/time?id=${time.id}" class="btn btn-secondary">Delete</a></td>
				    
				</tr>
			<%--</c:if> --%>
				
				</c:forEach>
			</tbody>
		</table>
		<a href="/user/add" class="btn btn-secondary">Add Associate</a>
	</div>
	<br></br>
	<div class="footer"><a href="/"> Return Home</a></div>
	<div class="footer"><a href="/">Exit</a></div>

</body>
</html>