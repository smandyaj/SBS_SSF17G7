<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="adminMenu.jsp" />

<div class="container">

	<c:choose>
		<c:when test="${employeeForm['new']}">
			<h1>Add Employee</h1>
		</c:when>
		<c:otherwise>
			<h1>Update Employee</h1>
		</c:otherwise>
	</c:choose>
	<br />

	<spring:url value="/employees" var="employeeActionUrl" />

	<form:form class="form-horizontal" method="post" modelAttribute="employeeForm" action="${employeeActionUrl}">

		<form:hidden path="id" />

		<spring:bind path="name">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">First Name</label>
				<div class="col-sm-10">
					<form:input path="name" type="text" class="form-control " id="name" placeholder="FirstName" />
					<form:errors path="name" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="name">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Last Name</label>
				<div class="col-sm-10">
					<form:input path="name" type="text" class="form-control " id="name" placeholder="LastName" />
					<form:errors path="name" class="control-label" />
				</div>
			</div>
		</spring:bind>
		
		
		<spring:bind path="email">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Email</label>
				<div class="col-sm-10">
					<form:input path="email" class="form-control" id="email" placeholder="Email" />
					<form:errors path="email" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="password">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Password</label>
				<div class="col-sm-10">
					<form:password path="password" class="form-control" id="password" placeholder="password" />
					<form:errors path="password" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="confirmPassword">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">confirm Password</label>
				<div class="col-sm-10">
					<form:password path="confirmPassword" class="form-control" id="password" placeholder="password" />
					<form:errors path="confirmPassword" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="address">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Address</label>
				<div class="col-sm-10">
					<form:textarea path="address" rows="5" class="form-control" id="address" placeholder="address" />
					<form:errors path="address" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="sex">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Sex</label>
				<div class="col-sm-10">
					<label class="radio-inline"> <form:radiobutton path="sex" value="M" /> Male
					</label> <label class="radio-inline"> <form:radiobutton path="sex" value="F" /> Female
					</label> <br />
					<form:errors path="sex" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="mobile">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Mobile</label>
				<div class="col-sm-10">
					<form:input path="mobile" class="form-control" id="email" placeholder="Mobile" />
					<form:errors path="mobile" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<c:choose>
					<c:when test="${employeeForm['new']}">
						<button type="submit" class="btn-lg btn-primary pull-right">Add</button>
					</c:when>
					<c:otherwise>
						<button type="submit" class="btn-lg btn-primary pull-right">Update</button>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</form:form>

</div>
</body>
</html>