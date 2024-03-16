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

h1 {
	color: red;
	margin-bottom: 20px;
}

form {
	background-color: black; /* Set background color to black */
	padding: 20px;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	color: white; /* Set text color to white */
	text-align: left; /* Align text to the left */
}

input {
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
	<h1 style="color: red">${msg}</h1>
	<form action="loginvalidation" method="post">
		enter email : <input type="email" name="email"><br> enter
		password : <input type="password" name="password"><br> <input
			type="submit" value="Login">
	</form>
</body>
</html>