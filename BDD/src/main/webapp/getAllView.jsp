<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import='java.sql.Connection'%>
<%@ page import='java.sql.ResultSet'%>
<%@ page import='com.jee.dao.UtilConnexion'%>
 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>Liste de produits</h1>
		<%
		Connection con = UtilConnexion.seConnecter();
		ResultSet rs = con.createStatement().executeQuery("SELECT * FROM product");
		if (request.getAttribute("msg") != null) {
		%>
			<h4>${msg}</h4>
		<% } %>
		<table>
			<tr> <th>IDP</th> <th>Name</th> <th>Description</th> <th>Price</th> <th>Delete</th> </tr>
			<% while (rs.next()){%>
				<tr> 
					<td><%= rs.getInt(1) %></td> 
					<td><%= rs.getString(2) %></td> 
					<td><%= rs.getString(3) %></td> 
					<td><%= rs.getFloat(4) %></td> 
					<td><a href="/BDD/deleteproduct?id=<%= rs.getInt(1) %>">Delete</a></td>
					<td><a href="/BDD/updateproduct?id=<%= rs.getInt(1) %>">Update</a></td>
					
				</tr>
			<% 
			} 
			rs.close();
			con.close();
			%>
		</table>
		
		
		<a href='/BDD/new'>new Product</a>
			
	</body>
</html>