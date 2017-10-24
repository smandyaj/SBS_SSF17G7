<script type="text/javascript">
</script>
<html>
<%@ taglib
prefix="c"
uri="http://java.sun.com/jsp/jstl/core" 
%>
<body>

</div>

<div>
	<div>
		<div>
				<h2 >Account Summary</h2>
				<div class="summary-acct">
					<div>Current balance:</div>
					<div>${CreditCard.getBalance()}</div> </div>
				</div>
				
						<div class="summary-acct-row">
						<div>late payment fee</div>
						<div>${CreditCard.getLatePayment()}</div> 
						</div>
						<div class="summary-acct-row">
						<div>credit limit</div>
						<div>${CreditCard.getCreditLimit()}</div>
					</div>			


	<h2> Account Summary TABLE </h2>
	<table style="width:80%;margin-left:10%;display: table-row-group;
vertical-align: middle;
border-color: inherit;
border-collapse: collapse;">

<tr>
<th>Current balance:</th>
<th>late payment fee</th>
<th>credit limit</th>	
</tr>

  		<tr>
  			<td>${CreditCard.getBalance()}</td>
    		<td>${CreditCard.getlatepayment()}</td>
    		<td>${CreditCard.getcreditlimit()}</td>
 		</tr>
 	
	</table>
 
</body>

</html>

