<%@page import="java.util.List"%>
<%@page import="com.jsp.shoppingcart.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
body {
	font-family: Arial, sans-serif;
	background-color: #212121;
	margin: 0;
	display: flex;
	align-items: center;
	justify-content: center;
	height: 100vh;
	flex-direction: column;
}

table {
	border-collapse: collapse;
	width: 80%;
	margin: 20px auto;
	background-color: black; /* Set background color to black */
	color: white; /* Set text color to white */
}

th, td {
	padding: 15px;
	border: 2px solid white;
	text-align: center;
}

th {
	background-color: #37474f; /* Set header background color */
}

a {
	text-decoration: none;
}

button {
	background-color: #4caf50;
	color: white;
	padding: 8px 12px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

button:hover {
	background-color: #45a049;
}
</style>
<body>
<%List<Product> product = (List<Product>) request.getAttribute("productslist");%>

<h1><a href="fetchitemsfromcart"><button>view cart</button></a></h1>

<table cellpadding="20px" border="2px">
		<th>brand</th>
		<th>model</th>
		<th>category</th>
		<th>price</th>
		<th>add to cart</th>
		<th>remove from cart</th>
		<%
		for(Product p : product){
		%>
		<tr>
			<td><%= p.getBrand() %></td>
			<td><%= p.getModel() %></td>
			<td><%= p.getCategory() %></td>
			<td><%= p.getPrice() %></td>
			<td><a href="additem?id=<%= p.getId()%>"><button>add</button></a></td>
			<td><a href="removeitem?id=<%= p.getId()%>"><button>remove</button></a></td>
		</tr>
		<% } %>
	</table>
</body>
</html>