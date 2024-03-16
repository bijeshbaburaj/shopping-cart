<%@page import="com.jsp.shoppingcart.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

form {
	background-color: black; /* Set background color to black */
	padding: 20px;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	color: white; /* Set text color to white */
	text-align: left; /* Align text to the left */
}

form input {
	width: 100%;
	padding: 8px;
	margin-bottom: 15px;
	box-sizing: border-box;
}

input[type="submit"] {
	background-color: #4caf50;
	color: white;
	padding: 10px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #45a049;
}
</style>
</head>
<body>
	<%
	Product p = (Product) request.getAttribute("productobj");
	%>
	<form action="updateproduct">
		id : <input type="number" name="id" value="<%=p.getId()%>" readonly="readonly"><br>
		brand : <input type="text" name="brand" value="<%=p.getBrand()%>"><br>
		category : <input type="text" name="category" value="<%=p.getCategory()%>"><br>
		model : <input type="text" name="model" value="<%=p.getModel()%>"><br>
		price : <input type="number" name="price" value="<%=p.getPrice()%>"><br>
		stock : <input type="number" name="stock" value="<%=p.getStock()%>"><br>
		<input type="submit">
	</form>
</body>
</html>