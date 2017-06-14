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
	 
	$("#dateStart").datepicker();
	$("#dateEnd").datepicker();
	
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
<div class="panel-heading">Select Date Range<span style="float:right;"><a href = "/expensemanager/logout.html"> Log Out</a>
</span></div>
<div class="panel-body">

<form class="form" action="reportsDateRange.html?userId=${userId }" method="post">
	
	<div class="form-group">
		  <label for="dateStart">Start Date:</label>
		  <input name="dateStart" id="dateStart" type="date" class = "form-control"
		   required="required"/>
		  
		  
	</div>
	<div class="form-group">
		  <label for="dateEnd">End Date:</label>
		  <input name="dateEnd" id="dateEnd" type="date" class = "form-control"
		   required="required"/>
		  
		  
	</div>
	
	<button class="btn-primary btn-block" type="submit">Generate Report</button>
	</form>


</div>
</div>
</div>
</body>
</html>