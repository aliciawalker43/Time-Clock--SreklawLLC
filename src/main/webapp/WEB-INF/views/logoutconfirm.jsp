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
<title>Logout Here</title>
</head>
<body>
<%@ include file="navbar.jsp"%>

<h1 align="center"> Quitting Time!!</h1>

<div class="container" align="center">
<h3>Please click submit to Clock-out.</h3>
<br>
<form action= "/endclock" method="post">
<button class="btn btn-outline-primary">Submit</button>
</form>
<h5>Thank you for your service!</h5>
</div>

<div class="container" align="center"><a href="/">Return to Homepage</a></div>

</body>
</html>