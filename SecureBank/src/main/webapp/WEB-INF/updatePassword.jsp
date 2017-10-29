<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Password</title>
</head>
<body>
	<form:form class="form-updatePassword" method="post"
		action="updatePasswordNow" attribute="UpdatePassword">
		<center>
			<div class="modal-body">
				<p>
					<label>Email-Id:</label> <input path="email" type="text"
						class="form-control" placeholder="***@gmail.com">
				</p>
			</div>
			<div class="modal-body">
				<p>
					<label>Password:</label> <input path="password" type="password"
						class="form-control" placeholder="*******">
				</p>
			</div>
	<!-- 		<div class="modal-body">
				<p>
					<label>Confirm Password:</label> <input name="confirmPassword" type="password"
						class="form-control" placeholder="*******">
				</p>
			</div> -->
			<div class="modal-footer">
				<button name="submit" value="confirm" type="submit"
					class="btn btn-success">Confirm</button>
			</div>
		</center>
	</form:form>
</body>
</html>