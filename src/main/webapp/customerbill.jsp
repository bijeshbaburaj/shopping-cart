<%@page import="com.jsp.shoppingcart.dto.Orders"%>
<%@page import="com.jsp.shoppingcart.dto.Item"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: black; /* Set background color to black */
	color: white; /* Set text color to white */
	padding: 20px;
}

h1 {
	text-align: center;
	margin-bottom: 20px;
	color: green;
}

table {
	width: 100%;
	border-collapse: collapse;
	border: 1px solid #fff; /* Set border color to white */
	background-color: black; /* Set background color to black */
	color: white; /* Set text color to white */
}

th, td {
	padding: 12px;
	text-align: left;
	border-bottom: 1px solid #fff; /* Set border color to white */
}

th {
	background-color: #333; /* Set background color to dark gray */
}

tr:nth-child(even) {
	background-color: #333;
	/* Set background color to dark gray for even rows */
}
</style>
</head>
<body>
	<%
	Orders orders = (Orders) request.getAttribute("orderdetails");
	List<Item> i = orders.getItems();
	%>
	<h1>${msg}</h1>
	<table>
		<thead>
			<th>Name</th>
			<th>Address</th>
			<th>Total price</th>
		</thead>
		<tbody>
			<tr>
				<td><%=orders.getName()%></td>
				<td><%=orders.getAddress()%></td>
				<td><%=orders.getTotalPrice()%></td>
			</tr>
		</tbody>
	</table>
</body>
</html>