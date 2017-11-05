<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"/>

<!--  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"/>-->
<!DOCTYPE html>
<html>

<%@ include file="customerMenu.jsp"%>

<div class="container">
			<h1> Merchant Request</h1>
			<spring:url value="/customer/verifyCVV" var="actionUrl" />
	<br />

	<c:if test="${not empty msg}">
			<div class="alert alert-${css} alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
				<strong>${msg}</strong>
			</div>
		</c:if>

	<form:form class="form-horizontal" method="post"
		modelAttribute="verifyCVVResult" action="verifyCVV" htmlEscape="true">
		
		

		<spring:bind path="account_id">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label"> Account Number</label>
				<div class="col-sm-10">
					<form:input path="account_id" class="form-control" id="account_id"
						placeholder="AccountNumber" />
					<form:errors path="account_id" class="control-label" />
				</div>
			</div>
		</spring:bind>


		<spring:bind path="amount">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Amount</label>
				<div class="col-sm-10">
					<form:input path="amount" class="form-control"
						id="amount" placeholder="TransactionAmount" />
					<form:errors path="amount" class="control-label" />
				</div>
			</div>
		</spring:bind>
		
		<spring:bind path="CVV">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">CVV</label>
				<div class="col-sm-10">
					<form:input path="CVV" class="form-control"
						id="cvv" placeholder="CVV" />
					<form:errors path="CVV" class="control-label" />
				</div>
			</div>
		</spring:bind>


		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn-lg btn-primary pull-right">Request</button>
			</div>
		</div>
	</form:form>

</div>
</body>
</html>