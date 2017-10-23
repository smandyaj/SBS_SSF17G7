<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
#customerMenu > ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #111;
}

#customerMenu > ul > li {
	float: left;
}

#customerMenu > ul > li > a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

/* Change the link color to #111 (black) on hover */
#customerMenu > ul > li > a:hover {
	background-color: #111;
}
</style>
</head>
<body>
	<div id="customerMenu">
		<ul id="customerList">
			<li><a href=#>Home</a></li>
			<li><a href="#">Accounts</a></li>
			<li><a href="makePayment">Make Payment</a></li>
			<li><a href="#">Transaction Management</a></li>
			<li><a href="CustomerProfile">Profile</a></li>
			<li><a href="#">Logout</a></li>
		</ul>
	</div>
</body>
</html>