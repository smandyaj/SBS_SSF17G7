<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
#tier1index ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
}
#tier1index li {
	float: left;
}
#tier1index li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

</style>
</head>

<body>
	<div id="tier1index">

		<div id="adminMenu">
		<ul>
			<li>Home</li>
				<ul>
					<li>Account Number</li>
					<li>Account Type</li>
					<form action="tier1index.jsp">
						<select name="acctype">
							<option value="checking">Checking</option>
							<option value="saving">Savings</option>
							<option value="credit">Credit Card</option>
						</select>
					<input type="submit" value="Submit">
					</form>
				</ul>
			<li>Notification</li>
			<li>Profile</li>
		</ul>
	</div>
		<ul>
			<li>Debit</li>
				<ul>
					<li>Debit Amount</li>
					<input type="submit" value="Approve">
				</ul>
			<li>Credit</li>
				<ul>
					<li>Credit Amount</li>
					<input type="submit" value="Approve">
				</ul>

			<li>Transfer</li>
				<ul>
					<li>Transfer to Cust ID: </li>
					<li>Amount</li>
				</ul>

		<c:forEach var="transactions" items="${transactions}">
				<tr>
					<td>${transactions.trans_id}</td>
					<td>${transactions.debitcredit}</td>
					<td>${transactions.approvedecline}</td>
						<input type="submit" value="Approve">
						<input type="submit" value="Decline">
				</tr>
		</c:forEach>

		</div>
</body>
</html>