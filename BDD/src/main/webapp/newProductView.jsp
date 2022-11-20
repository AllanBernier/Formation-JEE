<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		
		
		<% if (request.getAttribute("msg") != null) {%>
			<h4>${msg}</h4>
		<% } %>
		
		<form method="post">
			<label for='txtName'>Name :</label>
			<input type='text' name='txtName' placeholder='ex : Pinaple' autofocus>
			<br/>
			<label for='txtDesc'>Description :</label>
			<input type='text' name='txtDesc' placeholder='ex : Legume'>
			<br/>
			<label for='txtPrice'>Name :</label>
			<input type='text' name='txtPrice' placeholder='ex : 1.78'>
			<br/>
			<input type='submit'>
		</form>
	</body>
</html>