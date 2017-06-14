<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Home Page</title>
<link rel="stylesheet" href="https://bootswatch.com/darkly/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body class="container-fluid">

<div class="container">
<div class="jumbotron">
<h1>Expense Manager</h1>      
</div>

<div class="panel panel-default">
	<!-- Default panel contents -->
	<div class="panel-heading">Welcome ${user.firstName} !! 
	<span style="float:right;"><a href = "/expensemanager/logout.html"> Log Out</a></span>
	
	</div>
	
	<div class="panel-body">
		<div class="panel panel-default">
		<div class = "panel-heading">Expense List of ${user.firstName } ${user.lastName }
			<a href="reportsWeekly.html?userId=${user.id }" style= "float:right;">
				<span class="glyphicon glyphicon-file"></span><span> Generate Weekly report</span>
			</a>
			
				<a href="reportsDateRange.html?userId=${user.id }" style= "float:right;">
					<span class="glyphicon glyphicon-file"></span><span> Generate Expense Report Within Range    </span></a>
			
		 </div>
		
			<div class = "panel-body">
						<table class="table">
						
						<c:choose>
							<c:when test="${fn:length(user.transactions) < 1 }">
							No transactions have been recorded so far !
							</c:when>
							<c:when test="${fn:length(user.transactions)>=1 }">
								<tr>
									<th>Transaction Description</th>
									<th>Transaction Date</th>
									<th>Transaction Amount</th>
									<th>Operations</th>
								</tr>
								<c:forEach items="${user.transactions}" var="eachTransaction">
								<tr>
								<td>${ eachTransaction.description}</td>
								<td><fmt:formatDate value="${eachTransaction.transactionTime}" pattern="dd-MMM-yyyy"/>
								
								</td>
								<td>${ eachTransaction.amount}</td>
								<td>
								<div>
								<a href="ModifyExpense.html?userId=${user.id }&expenseId=${eachTransaction.id}">Modify Expense</a>
								</div>
								<div>
								<a href="DeleteExpense.html?userId=${user.id }&expenseId=${eachTransaction.id}">Delete Expense</a>
								</div>
								</td>
								</tr>
								</c:forEach>
							</c:when>
						</c:choose>
						</table>
						
					
				
			<a href="addNewExpense.html?userId=${user.id }">
			<span class="glyphicon glyphicon-plus-sign"></span><span> Add New Expense</span></a>
			</div>
		</div>
	</div>
</div>


</div>
</body>
</html>