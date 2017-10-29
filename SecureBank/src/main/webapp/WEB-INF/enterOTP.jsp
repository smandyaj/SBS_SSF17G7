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
<title>Enter the OTP</title>
</head>
<body>
	<form:form class="form-enterOTP" method="post" action="enterOTP" attribute="OtpForPassword">
		<center>
			<div class="modal-body">
				<p>
					<label>OTP:</label> <input name="otp" type="text"
						class="form-control" placeholder="10 digits">
				</p>
			</div>
			<div class="modal-footer">
				<button name="submit" value="confirm" type="submit"
					class="btn btn-success">Confirm</button>
				<button name="submit" value="cancel" type="submit"
					class="btn btn-danger">Cancel</button>
			</div>
		</center>
	</form:form>
</body>
</html>