<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<style>
#loginBox {
	width: 1000px;
	padding:20px;
	margin: 100px auto;
	background: #fff;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: 1px solid #000;
}
h3 {
    text-align: center;
}


body {font-family: "Lato", sans-serif;}

/* Style the tab */
div.tab {
    overflow: hidden;
    border: 1px solid #ccc;
    background-color: #f1f1f1;
}

/* Style the buttons inside the tab */
div.tab button {
    background-color: inherit;
    float: left;
    border: none;
    outline: none;
    cursor: pointer;
    padding: 14px 16px;
    transition: 0.3s;
    font-size: 17px;
}

/* Change background color of buttons on hover */
div.tab button:hover {
    background-color: #ddd;
}

/* Create an active/current tablink class */
div.tab button.active {
    background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
    display: none;
    padding: 6px 12px;
    border: 1px solid #ccc;
    border-top: none;
}
       
</style>
<body>

<div>
  <div class="container">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Employee</a>
    </div>
    <div class="tab">
  <button class="tablinks" onclick="">HOME</button>
  <button class="tablinks" onclick="">Notification</button>
  <button class="tablinks" onclick="">Profile Update</button>
</div>
    <div id="loginBox">
		<form name="loginForm" action="<c:url/>"
			method='POST'>
    <table>
				<tr>
					<td>CustomerID:</td>
					<td><input type='text' name='username'></td>
				</tr>
				<tr>
					<td>Account Type</td>
					<td><select name="accountType">
							<option value="savings">Savings</option>
							<option value="checking">Checking</option>
							<option value="creditCard">Credit Card</option>
					</select></td>
				</tr>
				<tr>
					<td colspan='2'><input name="search" type="submit"
						value="Submit" /></td>
				</tr>
				<tr>
			</table>
    </form>
</div>
</div>
</div>

<p>Transactions:</p>

<div class="tab">
  <button class="tablinks" onclick="">Debit</button>
  <button class="tablinks" onclick="">Credit</button>
  <button class="tablinks" onclick="">Transfer</button>
</div>
<div>
<div id="main" style="width:100%;overflow:hidden">
<h3 style="text-align:left">Authorize Transactions</h3>
<form >
	<table style="width:80%;display: table-row-group;
vertical-align: middle;
border-color: inherit;
border-collapse: collapse;
margin-left:10%">

  		<tr>
    		<th>Transaction ID</th>
    		<th>Sender</th>		
    		<th>Receiver</th>
    		<th>Amount</th>
    		<th>Date</th>
    		<th>Authorize</th>
  		</tr>
  			
  		<tr>

    		<td><input type="number" readonly="true" value="${a.getTransactionId()}"/></td>
    		<td><input type="number" readonly="true" value="${a.getTransactionId()}"/></td>		
			<td><input type="number" readonly="true" value="${a.getTransactionId}"/></td>
    		<td><input type="number" readonly="true" value="${a.getTransactionId()}"/></td>
    		<td><input readonly="true" value="${a.getTime()}"/></td>
    		<td><select name="values">
  					<option value="Approve">Approve</option>
  					<option value="Reject">Reject</option>
				</select>
			</td>
 		</tr>
		
	</table>
				<input id="authorize" type="submit" value="Authorize" class="btn btn-default" style="float:right;margin-right:30%;margin-top:5px;" name="authorize"/>
	</form>
</div>
</div>
</body>

</html>
</body>
</html>
