<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Login Page</title>
<style>
#loginBox {
	width: 300px;
	padding: 20px;
	margin: 100px auto;
	background: #fff;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: 1px solid #000;
}
</style>
</head>
<body>
	<div id="loginBox">
		<form name="loginForm" action="<c:url value='/customerRedirect'/>"
			method='POST'>
			<table>
				<tr>
					<td>User:</td>
					<td><input type='text' name='username'></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type='password' name='password' /></td>
					<!--  use keyboard for security -->
				</tr>
				<tr>
					<td>Account Type</td>
					<td><select name="accountType">
							<option value="savings">Savings</option>
							<option value="checking">Checking</option>
							<option value="creditCard">Credit Card</option>
					</select></td>
				</tr>
				<tr>
					<td colspan='2'><input name="submit" type="submit"
						value="Submit" /></td>
				</tr>
				<tr>
			</table>

			<span><a href="newUser"><button>Sign up</button></a></span> <span><a
				href="forgotPassword"><button>Forgot Password</button></a></span>

		</form>

	</div>
</body>
</html>