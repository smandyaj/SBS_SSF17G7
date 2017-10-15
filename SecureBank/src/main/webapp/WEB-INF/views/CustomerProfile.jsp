<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="CustomerMenu.jsp" %>
<title>Profile</title>
</head>
<body>
<div class="tab-pane" id="Tab2">
        					<div class="page-header" style="margin-top: 5px;" align="center">
    							<h3>${first_name} ${last_name}</h3>
    						</div>
    						<form:form id="profileForm" class="form-horizontal" action="profile" commandName="profile" method="POST">
  						
  						<div class="form-group">
    						<label for="username" class="col-sm-2 control-label">First Name</label>
    					<div class="col-sm-8">
    								<p>
    								${first_name}
    								</p>
    					</div>
   						</div>
   						
  						<div class="form-group">
    						<label for="username" class="col-sm-2 control-label">Last Name</label>
    							<div class="col-sm-8">
    								<p>
    								${last_name}
    								</p>
    							</div>
  						</div>
  						<div class="form-group">
    						<label for="inputContact" class="col-sm-2 control-label">User Type</label>
    							<div class="col-sm-8">
    								<p>
    								${customer_type}
    								</p>
    							</div>
  						</div>
  						<div class="form-group">
    						<label for="username" class="col-sm-2 control-label">Username</label>
    							<div class="col-sm-8">
    								<p>
    								${customer_id}
    								</p>
    							</div>
  						</div>
  						<div class="form-group">
    						<label for="inputEmail" class="col-sm-2 control-label">Email</label>
    							<div class="col-sm-8">
    								<p>
    								${email_id}
    								</p>
    							</div>
  						</div>
  						
  						<div class="form-group">
    						<label for="inputEmail" class="col-sm-2 control-label">Account No</label>
    							<div class="col-sm-8">
    								<p>
    								${accountno}
    								</p>
    							</div>
  						</div>
  						<div class="form-group">
    						<label for="inputContact" class="col-sm-2 control-label">Contact Number</label>
    							<div class="col-sm-8">
    								<p>
    								${contactNo}
    								</p>
    							</div>
  						</div>
  						
  						<div class="form-group">
    						<label for="inputAddress" class="col-sm-2 control-label">Address</label>
    							<div class="col-sm-8">
    								<p>
    								${customer_address}
    								</p>
    							</div>
  						</div>
  						
  						<div class="form-group">
    						<label for="inputAddress" class="col-sm-2 control-label">City</label>
    							<div class="col-sm-8">
    								<p>
    								${city}
    								</p>
    							</div>
  						</div>
  						
  						<div class="form-group">
    						<label for="inputAddress" class="col-sm-2 control-label">State</label>
    							<div class="col-sm-8">
    								<p>
    								${state}
    								</p>
    							</div>
  						</div>
  						
  						<div class="form-group">
    						<label for="inputAddress" class="col-sm-2 control-label">Country</label>
    							<div class="col-sm-8">
    								<p>
    								${country}
    								</p>
    							</div>
  						</div>
  						
  						<div class="form-group">
    						<label for="inputAddress" class="col-sm-2 control-label">Zipcode</label>
    							<div class="col-sm-8">
    								<p>
    								${zip}
    								</p>
    							</div>
  						</div>
						
  						
  						
					</form:form>
        				</div>
</body>
</html>