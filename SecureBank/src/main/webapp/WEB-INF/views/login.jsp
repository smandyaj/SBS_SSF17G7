<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script>
function myFunction1() {
    document.getElementById("demo1").innerHTML = "You pasted text!";
	alert("Don't copy paste");
}
function myFunction2() {
	var s = document.getElementById("inputEmail").value;
	var s2 = document.getElementById("inputPassword").value;
	var regex = /=/; // match '=' and capture everything that follows
	var matches = s.match(regex);
	var matches2 = s.match(regex);
	if (matches) {
	    alert("Invalid Input")
	}
	if (matches2) {
	    alert("Invalid Input")
	}
	
	}

</script>
<!--

//-->
</script>

<t:auth>



	<form class="form-signin" method="post"
		action=${pageContext.servletContext.contextPath}/login htmlEscape="true">
		<div>
			<c:if test="${!empty successMsg}">
				<div class="alert alert-success">${fn:escapeXml(successMsg)}</div>
			</c:if>

			<c:if test="${!empty error}">
				<div class="alert alert-danger">${fn:escapeXml(error)}</div>
			</c:if>

			<c:if test="${!empty failureMsg}">
				<div class="alert alert-danger">${fn:escapeXml(failureMsg)}</div>
			</c:if>

			<h3>Secure Bank Login</h3>
			<h2 class="form-signin-heading">Please Login</h2>

			<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
				<div class="form-errors">
					Your login attempt was not successful due to:
					<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
					.
				</div>
			</c:if>


			<label for="username" class="sr-only">User Name</label> <input
				name="username" type="text" onpaste="myFunction1()" id="inputEmail" class="form-control"
				placeholder="User Name" required="" autofocus=""
				autocomplete="off"> <label for="inputPassword"
				class="sr-only">Password</label> <input name="password"
				type="password" id="inputPassword" class="form-control"
				placeholder="Password" required="" autocomplete="off">
			<!-- <div class="g-recaptcha"
			data-sitekey="6LcQrwwTAAAAAP1rFCMhODCuHWbbkgC9mJ2Qm6gz"></div> -->
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<button class="btn btn-lg btn-primary btn-block"  onclick="myFunction2()" type="submit">Sign
				in</button>

			<p class="center">
				<a href="forgotpass">Forgot Password?</a>
			</p>
		</div>
		<%--Cross site scripting protection --%>
			<spring:htmlEscape defaultHtmlEscape="true" /> 
		
	</form>


	<div id="virtualKeyboard"></div>


</t:auth>
