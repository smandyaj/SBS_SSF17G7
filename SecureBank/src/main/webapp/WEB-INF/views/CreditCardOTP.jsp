<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"/>
<script src=${pageContext.request.contextPath}/assets/js/jquery-3.2.1.min.js></script>

<link href=${pageContext.request.contextPath}/assets/CSS/jquery.virtual_keyboard.css rel="stylesheet">
<script src=${pageContext.request.contextPath}/assets/js/jquery.virtual_keyboard.js></script>
	<script>
	jQuery(document).ready(function() {
	$('#otpvalueid').keyboard({
  // Keyboard Type
  type: 'gatekeeper', 
  // default, monokai, orange
  theme: 'default', 
  // ru_RU, es_ES, pt_PT, it_IT
  language: 'en_US',
  // active Shift key
  active_shift: false,
  // action Capslock key
  active_caps: false,
  // hide the keyboard on page load
  is_hidden: true,
  // animation speed in ms
  open_speed: 300,
  close_speed: 300,
  // show on focus
  show_on_focus_in: true,
  // auto hide when the text field has lost focus.
  hide_on_focus_out: true,
  // Id selector to trigger the keyboard
  trigger: undefined, 
  // enable the plugin
  enabled: true
})
});
</script>

  <%@ include file="customerMenu.jsp" %>
	<div class="page-header">
		<h1>${fn:escapeXml(heading)}</h1>
	</div>

	<div id="add-withdraw">
		<form:form id="otp" method="POST" modelAttribute="transaction" action=${pageContext.request.contextPath}/customer/creditcard/process-otp htmlEscape="true">
			<div>
				<c:if test=${!empty successMsg}>
					<div class="alert alert-success">						
						${fn:escapeXml(successMsg)}
					</div>
				</c:if>
				<c:if test="${!empty failureMsg}">
					<div class="alert alert-danger">						
						${fn:escapeXml(failureMsg)}
					</div>
				</c:if>
				<div class="modal-header">
					<h4 class="modal-title">Please verify your transaction by using the one time password sent to you by email</h4>
				</div>
				<div class="modal-body">
					<p>
						<label>OTP:</label>
						<input name="otp" id="otpvalueid" type="text" class="form-control" placeholder="8 digits">
					</p>
					<input name="otpId" type="hidden" class="form-control" value="${otpId}">
					<input name="transactionId" type="hidden" class="form-control" value="${transactionId}">
					<input name="type" type="hidden" class="form-control" value="${type}">
				</div>
				<div class="modal-footer"> 
					<button name="submit" value="confirm" type="submit" class="btn btn-success">Confirm Transaction</button>
					<button name="submit" value="cancel" type="submit" class="btn btn-danger">I want to cancel this transaction</button>
				</div>
			</div>
			<%--Cross site scripting protection --%>
			<spring:htmlEscape defaultHtmlEscape="true" /> 

		</form:form>
		<!-- /form -->
	</div>
	
	<div id="virtualKeyboard"></div>
	<!-- /#add-withdraw -->