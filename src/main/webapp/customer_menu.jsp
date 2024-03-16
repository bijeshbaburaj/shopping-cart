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
	<h1 style="color: green">${message}</h1>
	<h1>
		<a href="addcustomer">Register Account</a>
	</h1>

	<br>
	<h2>
		<a href="customerloginform.jsp">Login</a>
	</h2>
	<br>
</body>
</html>