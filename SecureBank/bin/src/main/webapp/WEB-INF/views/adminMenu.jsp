<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
#adminMenu ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
}

#adminMenu li {
	float: left;
}

#adminMenu li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

/* Change the link color to #111 (black) on hover */
#adminMenu li a:hover {
	background-color: #111;
}
</style>
</head>
<body>
	<div id="adminMenu">
		<ul>
			<li>Home</li>
			<li>Employee Management</li>
			<li>Requests Pending</li>
			<li>System Log</li>
			<li>PII</li>
			<li>Profile</li>
			<li>Logout</li>
		</ul>
	</div>
</body>
</html>