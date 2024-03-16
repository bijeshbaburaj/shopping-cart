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
	flex-direction: column; /* Add this line */
}

h1 {
	text-align: center;
	color: #333;
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
</style>
</head>
<body>
	<h1>
		${message} <br> 
		<a href="addmerchant">Create Account</a>
	</h1>
	<br>
	<h1>
		<a href="merchantloginform.jsp">Login</a>
	</h1>

	<br>
</body>
</html>