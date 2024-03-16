<%@page import="com.jsp.shoppingcart.dto.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.jsp.shoppingcart.dto.Merchant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	Merchant merchant = (Merchant) session.getAttribute("merchantinfo");
	List<Product> products = merchant.getProduct();
	%>
	<table cellpadding="20px" border="2px">
		<thead>
			<th>id</th>
			<th>brand</th>
			<th>model</th>
			<th>category</th>
			<th>price</th>
			<th>stock</th>
			<th>update</th>
			<th>delete</th>
		</thead>
		<%
		for (Product p : products) {
		%>
		<tbody>
			<tr>
				<td><%=p.getId()%></td>
				<td><%=p.getBrand()%></td>
				<td><%=p.getModel()%></td>
				<td><%=p.getCategory()%></td>
				<td><%=p.getPrice()%></td>
				<td><%=p.getStock()%></td>
				<td><a href="getproducttoupdate?id=<%=p.getId()%>"><button>update</button></a></td>
				<td><a href="deleteproduct?id=<%=p.getId()%>"><button>delete</button></a></td>
			</tr>
		</tbody>
		<%
		}
		%>

	</table>
</body>
</html>