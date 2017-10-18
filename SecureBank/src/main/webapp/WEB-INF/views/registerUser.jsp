<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
					<html>

					<head>
						<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
						<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
						<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
						<title>{Bank Name}</title>
					</head>

					<body>

						<div class="row">
							<div class="col-md-3"></div>
							<div class="col-md-6" style="padding-top: 40px">
								<div class="panel panel-default" style="background: #918383">
									<div class="panel-body">
										<div class="page-header" style="margin-top: 5px;" align="center">
											<h3>
												</span>New User Sign Up</h3>
										</div>

										<form class="form-horizontal" method="POST" action="register-user" commandName="registerPage">
											<input type="hidden" name="id" value="${user.id}" />
											<div class="form-group">
												<label class="control-label col-md-3">FIRST NAME</label>
												<div class="col-md-7">
													<input type="text" class="form-control" name="first_name" value="${first_name}" />
												</div>

											</div>

											<div class="form-group">
												<label class="control-label col-md-3">LAST NAME</label>
												<div class="col-md-7">
													<input type="text" class="form-control" name="last_name" value="${last_name}" />
												</div>

											</div>

											<div class="form-group">
												<label class="control-label col-md-3">EMAIL ID</label>
												<div class="col-md-7">
													<input type="email" class="form-control" name="email_id" value="${email_id}" />
												</div>
											</div>

											<div class="form-group">
												<label class="control-label col-md-3">Password</label>
												<div class="col-md-7">
													<input type="password" class="form-control" name="password" value="${user.password }" />
												</div>

											</div>

											<div class="form-group">
												<label class="control-label col-md-3">Confirm Password</label>
												<div class="col-md-7">
													<input type="password" class="form-control" name="password" value="${user.password }" />
												</div>

											</div>

											<div class="form-group">
												<label class="control-label col-md-3">Account Type </label>
												<div class="col-md-7">
													<input type="radio" class="col-sm-1" name="finished" value="savings" checked/>
													<div class="col-sm-3">Savings</div>
													<input type="radio" class="col-sm-1" name="finished" value="checking" />
													<div class="col-sm-3">Checking</div>
													<input type="radio" class="col-sm-1" name="finished" value="credit" />
													<div class="col-sm-3">Credit</div>

												</div>

											</div>

											<div class="form-group">
												<label class="control-label col-md-3">Phone</label>
												<div class="col-md-7">
													<input type="text" class="form-control" name="phone" maxlength="10" value="${phone}" />
												</div>

											</div>



											<div class="form-group">
												<label class="control-label col-md-3">Address</label>
												<div class="col-md-7">
													<input type="text" class="form-control" name="customer_address" value="${customer_address}" />
												</div>

											</div>


											<div class="form-group">
												<label class="control-label col-md-3">State</label>
												<div class="col-md-7">
													<input type="text" class="form-control" name="state" value="${state}" />
												</div>

											</div>

											<div class="form-group">
												<label class="control-label col-md-3">Country</label>
												<div class="col-md-7">
													<input type="text" class="form-control" name="country" value="${country}" />
												</div>

											</div>

											<div class="form-group">
												<label class="control-label col-md-3">ZIP</label>
												<div class="col-md-7">
													<input type="text" class="form-control" name="zip" value="${zip}" />
												</div>

											</div>

											<div class="form-group">
												<div class="col-sm-offset-2 col-sm-10">
													<h6 align="center">
														<button type="submit" class="btn btn-success">Create Account</button>
													</h6>

												</div>
											</div>

										</form>
									</div>
								</div>


							</div>
						</div>

					</body>

					</html>