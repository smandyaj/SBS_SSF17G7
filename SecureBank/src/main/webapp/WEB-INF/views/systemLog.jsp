<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Systems Log</title>
</head>
<body>
<jsp:include page="adminMenu.jsp" />
<div class="container">
<c:if test="${not empty msg}">
			<div class="alert alert-${css} alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<strong>${msg}</strong>
			</div>
		</c:if>

		<h1>All employeess</h1>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>TimeStamp</th>
					<th>FirstName</th>
					<th>LastName</th>
					<th>Action</th>
				</tr>
			</thead>

			<c:forEach var="logs" items="${systemLogs}">
				<tr>
					<td>
						${logs.timeStamp}
					</td>
					<td>${logs.firstName}</td>
					<td>${logs.lastName}</td>
					<td>${logs.action}</td>
				</tr>
			</c:forEach>
		</table>

	</div>
</body>
</html>