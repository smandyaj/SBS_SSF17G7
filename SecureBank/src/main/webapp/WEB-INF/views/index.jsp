<!-- <!DOCTYPE html> -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Home</title>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

	<link href="/jquery-ui.min.css"  rel="stylesheet">

	<script>
		$(function(){
			$('#userPassword').keyboard();
		});
	</script>
  </head>
  <body>
  	<p></br></p>
  	<div class="row">
  		<div class="col-md-3"></div>
  		<div class="col-md-6" style="padding-top: 40px">
  			<div class="panel panel-default" style="background: #918383">
  				<div class="panel-body" >
    				<div class="page-header" style="margin-top: 5px;" align="center">
    				<h3></span>{Bank Name} </h3>
    				</div>
    				<!-- <form:form class="form-horizontal" commandName="loginPage" method="POST">
  						<div class="form-group">
    						<label for="userEmail" class="col-sm-2 control-label">Username</label>
    							<div class="col-sm-8">
    								<div class="input-group">
  										<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
      									<form:input path = "userId" type="text" class="form-control" id="userEmail" placeholder="Username" maxlength="16"/>
      								</div>
    							</div>
  						</div>
  						<div class="form-group">
    						<label for="userPassword" class="col-sm-2 control-label">Password</label>
   							<div class="col-sm-8">
   								<div class="input-group">
  										<span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
     									<form:input path = "passwd" type="password" class="form-control" id="userPassword" placeholder="Password" maxlength="16"/>
   			 					</div>
   			 				</div>
  						</div>
  						<div class="form-group">
    						<div class="col-sm-offset-2 col-sm-10">
    						<a href="register" role="button" class="btn btn-primary">Register</a>
    						<button type="submit" class="btn btn-success" >Sign-in</button>
    						<h6><a href="forgotPass" role="button" class="btn btn-danger">Forgot Password?</a></h6>
    						</div>
  						</div>
					</form:form>		 -->
					<form class="form-horizontal" method="POST" action="login-user" commandName="loginPage">
						<input type="hidden" name="id" value="${user.id}" />
						<div class="form-group">
							<label class="control-label col-md-3">UserName</label>
							<div class="col-md-7">
								 <input type="text" class="form-control" name="username" value="${user.name }"/>
							</div>
						
						</div>
					
						<div class="form-group">
							<label class="control-label col-md-3">Password</label>
							<div class="col-md-7">
								<input type="password" class="form-control" name="password" value="${user.password }" placeholder="Password" required/>
							</div>
						
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-3">You are</label>
							<div class="col-md-7">
									<input type="radio" class="col-sm-1" name="finished" value="customer" checked/>
									<div  class="col-sm-3">Customer</div>
									<input type="radio" class="col-sm-1" name="finished" value="admin"/>
									<div  class="col-sm-3">Admin</div>
									<input type="radio" class="col-sm-1" name="finished" value="employee"/>
									<div  class="col-sm-3">Employee</div>
								
							</div>
						
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
							<h6><button type="submit" class="btn btn-success" >Sign-in</button></h6>
							<h6><a href="registerUser" role="button" class="btn btn-primary">Register</a> <a href="forgotPassword" role="button" class="btn btn-danger">Forgot Password?</a></h6>
							
							</div>
						  </div>
					
					</form>
  				</div>
			</div>
			
			<div>
			<p>
			${message}
			
			</p>
			</div>
  		
  		
  		</div>
  		<div class="col-md-2"></div>
	</div>

    
  </body>
</html>
