<%@page import="com.jsp.shoppingcart.dto.Customer"%>
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
	Customer customer = (Customer) session.getAttribute("customerinfo");
	%>
	<%
	if (customer != null) {
	%>
	<h1 style="color: green">${msg}<%=customer.getName() %></h1>
	<h1>
		<a href="displayallproducts">Display all product</a>
	</h1>
	<h1>
		<a href="readbrandfromcustomer.jsp">Display product by brand</a>
	</h1>
	<h1>
		<a href="readcategoryfromcustomer.jsp">Display product by category</a>
	</h1>
	<h1>
		<a href="readpricerangefromcustomer.jsp">Display product between
			range</a>
	</h1>
	<%
	} else {
	%>
	<h1>
		<a href="customerloginform.jsp">please login first</a>
	</h1>
	<%
	}
	%>

</body>
</html>