<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Applications</title>
<link rel="stylesheet" href="https://bootswatch.com/darkly/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body class="container-fluid">

<div class="container">
<center>
<h1>Expense Manager</h1>      
</center>
  <div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading">Login</div>
  <div class="panel-body">
<div>
	<form class="form" method="post">
		<div class="form-group">
		  <label for="email">Email address</label>
		  <input type="email" class="form-control" name="email" placeholder="Email">
		</div>
		<div class="form-group">
		  <label for="password">Password</label>
		  <input type="password" class="form-control" name="password" placeholder="Password">
		</div>
		<button class="btn-primary btn" type="submit">Login</button>
		<a href = "Register.html" class = "btn-primary btn">
		Register
		</a>
		<c:if test="${error == 'yes' }">
		<div>Email Id or Password is wrong. Try again or Sign Up!</div>
		</c:if>
	</form>
	
</div>
  </div>  
</div>    
</div>

</body>
</html>
