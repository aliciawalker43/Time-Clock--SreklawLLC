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
<title>Login Page</title>
</head>
<body>
<%@ include file="navbar.jsp"%>

<div class="container" align="center">	
<h1>Welcome!</h1>
 <p> ${date}</p>

</div>

<div class="container" align="center">	     
                <dd><div class="btn btn-light btn-lg btn-block"><a href="/start"> START SHIFT</a></div></dd>
				<dd><div  class="btn btn-outline-primary btn-block"><a href="/newtenant"> View Property List</a></div> </dd>
				<dd><div  class="btn btn-outline-primary btn-block"><a href="/recordexpense"> Record Expense</a> </div></dd>
				<dd><div  class="btn btn-outline-primary btn-block"><a href="/repairs"> upload receipts</a> </div></dd>
				<dd><div  class="btn btn-outline-primary btn-block"><a href="/timecard"> View Time Card</a></div> </dd>
				<dd><div  class="btn btn-outline-primary btn-block"><a href="/edocuments">Policy & Procedures</a> </div></dd>
				<dd><div  class="btn btn-outline-primary btn-block"><a href="/directory">Contractors List</a> </dd>
				<dd><div class="btn btn-light btn-lg btn-block" ><a href="/end"> END SHIFT</a></div></dd>
				</div>
				


</body>
</html>