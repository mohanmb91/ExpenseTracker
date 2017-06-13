<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Expense Management</title>
<link rel="stylesheet" href="https://bootswatch.com/darkly/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body class="container-fluid">

<div class="container">
<div class="jumbotron">
<center>
<h1>Expense Manager</h1>      
</center>    
</div>
  <div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading">Registration</div>
  <div class="panel-body">
  
  <form:form class="form" modelAttribute="user">
	  <div class="form-group">
		  <label for="email">Email address</label>
		  <form:input path="emailId" type="email" class="form-control" name="email" placeholder="Email" required="required"/>
	   </div>
	   <div class="form-group">
	   <label for="password">Password</label>
		  <form:input path="password" type="password" class="form-control" name="password" placeholder="Password" required="required"/>
		</div>
		<div class="form-group">
	   <label for="firstname">First Name</label>
		  <form:input path="firstName" type="text" class="form-control" name="firstname" placeholder="firstname" required="required"/>
		</div>
		<div class="form-group">
	   <label for="lastname">Last Name</label>
		  <form:input path="lastName" type="text" class="form-control" name="lastname" placeholder="lastname" required="required"/>
		</div>
		<button class="btn-primary btn" type="reset">Clear</button>
		<button class="btn-primary btn" type="submit">Register</button>
		<c:if test="${error == 'yes' }">
		<div>email id already exist plz register again</div>
		</c:if>
</form:form>
</div>
</div>
</div>

</body>
</html>