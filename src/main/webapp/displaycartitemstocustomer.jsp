<%@page import="com.jsp.shoppingcart.dto.Item"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
</head>
<body>
	<%
	List<Item> items = (List<Item>) request.getAttribute("itemlist");
	%>

	<table cellpadding="20px" border="2px solid black">
		<thead>
			<th>Brand</th>
			<th>model</th>
			<th>Category</th>
			<th>Quantity</th>
			<th>Price</th>
		</thead>

		<%
		for (Item i : items) {
		%>
		<tbody>
			<tr>
				<td><%=i.getBrand()%></td>
				<td><%=i.getModel()%></td>
				<td><%=i.getCategory()%></td>
				<td><%=i.getQuantity()%></td>
				<td><%=i.getPrice()%></td>
			</tr>
			<%
			}
			%>
			<tr>
				<td colspan="4" align="center"><button><a href="addorder">buy now</a></button></td>
				<td>Total Price : ${totalprice}</td>
			</tr>
		</tbody>



	</table>
</body>
</html>