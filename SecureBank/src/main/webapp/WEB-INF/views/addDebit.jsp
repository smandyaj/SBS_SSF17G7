<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Home Page</title>
</head>
<body>
<%@ include file="customerMenu.jsp"%>
Hello !!!!
<br>
<label for="debit" class="sr-only">Enter money to debit:</label> <input
				name="debit" type="text" id="inputDebit" class="form-control"
				placeholder="Enter Money ex:100$" required="" autofocus=""
				autocomplete="off">
				<br>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Debit</button>
</body>
</html>