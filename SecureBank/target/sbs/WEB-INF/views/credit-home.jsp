<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
</script>
<html>
<head><link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"/>
</head>
<body>
<%@ include file="customerMenu.jsp"%>


	
 
<h2> Account Summary  </h2>
	<table border="1">

<tr>
<th>accountId</th>
<th>Current balance</th>
<th>Details</th>
</tr>
  		
 	<c:forEach var="account" items="${accounts}">
   <tr>
   <td>${account.accountId}</td>
    <td>${account.accountBalance}</td> 
      <td><a href=${pageContext.request.contextPath}/customer/creditcard/${account.accountId} >Details</a>

            </td> 
    </tr>
</c:forEach>
 	
 	
 	
 	
 	
</table>








</body>

</html>


