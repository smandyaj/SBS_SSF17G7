<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<!-- <label for="debit" class="sr-only">Enter money to debit:</label> <input
				name="debit" type="text" id="inputDebit" class="form-control"
				placeholder="Enter Money ex:100$" required="" autofocus=""
				autocomplete="off">
				<br>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Debit</button> -->
				
				<%-- <form:form method="POST" modelAttribute="accDebitSuccess" action="customer-debit" >
          <c:if test="${!empty successMsg}">
					<div class="alert alert-success">						
						${fn:escapeXml(successMsg)}
					</div>
				</c:if>
          	<c:if test="${!empty failureMsg}">
					<div class="alert alert-danger">						
						${fn:escapeXml(failureMsg)}
					</div>
				</c:if>
            <p>
              <label>Enter money to debit:</label>
              <form:input  path = "customerId" type="text" class="form-control" placeholder="Enter Money ex:100$" maxlength="11" minlength="1" required= "required"></form:input>
            </p>
			<div class="modal-footer" >                
              <button type="submit" class="btn btn-success">Debit</button>
            </div>
		   </form:form> --%>
		   
		   <%-- <form:form class="form-horizontal" action="debit-money" commandName="debit" method="POST">
    							
	        						<div class="page-header" style="margin-top: 5px;" align="center">
	    								<h3>Debit Money</h3>
	    							</div>
	    							
	    							<div class="form-group">
    								<label for="displayAccountBalance" id="displayBalance" class="col-lg-2 control-label">Account Balance</label>
    								<form:label path="balance" for="displayAmount" class="col-lg2 control-label">${debitOp.getBalance()}</form:label>
  									</div>
  					
  								
	  								<div class="form-group">
	    								<label for="inputAmount" class="col-lg-2 control-label">Amount</label>
	   										<div class="col-sm-10">
	   											<div class="col-sm-24">
	     										
	     										<form:input path="transactionAmount" type="number" class="form-control" id="inputAmount" placeholder="Enter Amount" min="0" />
	     											
	   			 								</div>
	   			 							</div>
	  								</div>
	  								
	  								<div class="form-group">
	    								<div class="col-lg-offset-2 col-lg-10">
	    									<button type="submit" class="btn btn-primary">Submit</button>
	     										<button type="reset" class="btn btn-success">Cancel</button>
	    								</div>
	    							</div>
    						</form:form> --%>
</body>
</html>