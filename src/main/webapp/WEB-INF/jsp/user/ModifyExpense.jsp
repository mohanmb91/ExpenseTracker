<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Applications</title>
	

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>   
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://bootswatch.com/darkly/bootstrap.min.css">
 
  <script type="text/javascript">
  $(document).ready(function(){
	 var transactionDate = $("#hiddenDate").val();
	    document.getElementById("dateselector").value = transactionDate;
  });
  </script>
</head>
<body class="container-fluid">

<div class="container">
<div class="jumbotron">
<h1>Expense Manager</h1>      
</div>

<div class="panel panel-default">
<!-- Default panel contents -->
<div class="panel-heading">Add New Expense <span><a href = "/expensemanager/logout.html"> Log Out</a>
</span></div>
<div class="panel-body">

<form:form class="form" modelAttribute="expense" action="ModifyExpense.html?userId=${userId }&expenseId=${expense.id }" method="post">
	
	<div class="form-group">
		  <label for="amount">Amount in USD:</label>
		  <form:input name="amount" path="amount" type="number" step="0.01" class = "form-control" placeholder="amount" value="${expense.amount}" required="required"/>
	</div>
	<div class="form-group">
		  <label for="description">Description:</label>
		  <form:input name="description" path="description" value="${expense.description }" type="text" class = "form-control" placeholder="description" required="required"/>
	</div>
	<c:set var="transactionDate" value="${expense.transactionTime }" />
	<div class="form-group">
		  <label for="date">Date:</label>
		  <input type="hidden" id="hiddenDate" value="<fmt:formatDate value="${expense.transactionTime}" pattern="yyy-MM-dd"/>">
		  
		  <input name="date" id="dateselector" type="date" class = "form-control"
		   required="required"/>
		  
		  
	</div>
	
	<button class="btn-primary btn-block" type="submit">Save Expense Details</button>
	</form:form>


</div>
</div>
</div>
</body>
</html>