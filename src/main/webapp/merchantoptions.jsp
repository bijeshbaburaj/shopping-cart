<%@page import="com.jsp.shoppingcart.dto.Merchant"%>
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
	background-color: black;
	margin: 0;
	display: flex;
	align-items: center;
	justify-content: center;
	height: 100vh;
	flex-direction: column;
}

h1 {
	text-align: center;
	margin-bottom: 20px;
}

a {
	color: #007BFF;
	text-decoration: none;
	font-weight: bold;
}

a:hover {
	text-decoration: underline;
}

/* Optional: Add some spacing */
h1:not(:last-child) {
	margin-bottom: 20px;
}
</style>
</head>
<body>
	<%
	Merchant m = (Merchant) session.getAttribute("merchantinfo");
	%>
	<%
	if (m != null) {
	%>
	<h1 style="color: green">${msg}<%= m.getName() %></h1>
	<h1 style="color: green">${message}</h1>
	<h1>
		<a href="addproduct">add product</a>
	</h1>
	<br>
	<h1>
		<a href="viewallproduct.jsp">view all product</a>
	</h1>
	<br>
	<%
	} else {
	%>
	<h1>
		<a href="merchantloginform.jsp">please login first !!!</a>
	</h1>
	<%
	}
	%>
</body>
</html>