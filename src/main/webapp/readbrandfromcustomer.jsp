<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
body {
	background-color: black; /* Set background color to black */
	color: white; /* Set text color to white */
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	margin: 0;
}

form {
	background-color: black; /* Set form background color to black */
	padding: 20px;
	border-radius: 10px;
	max-width: 300px;
	text-align: center;
}

input[type="text"] {
	width: 80%;
	padding: 10px;
	margin: 5px 0;
	box-sizing: border-box;
	border: none;
	border-radius: 5px;
	background-color: #333; /* Dark gray for search bar background */
	color: white;
}

input[type="submit"] {
	width: 80%;
	padding: 10px;
	margin-top: 10px;
	box-sizing: border-box;
	border: none;
	border-radius: 5px;
	background-color: #007bff; /* Blue for submit button background */
	color: white;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #0056b3; /* Darker blue on hover */
}

/* Search icon */
.search-icon {
	position: absolute;
	margin-left: 10px;
	margin-top: 13px;
	color: white;
}
</style>
<body>
	<form action="displayproductbybrand">
    <label for="brand">Enter brand:</label>
    <input type="text" id="brand" name="brand" placeholder="Search...">
    <i class="fa fa-search search-icon"></i>
    <input type="submit" value="Submit">
</form>
</body>
</html>