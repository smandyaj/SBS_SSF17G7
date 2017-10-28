<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<%@ include file="customer-menu.jsp"%>
	<div class="page-header">
		<h1>Welcome ${fn:escapeXml(fullname)}</h1>
		<h4>Customer Id: ${fn:escapeXml(customerId) }</h4>
	</div>

	<h2>Accounts:</h2>

	<table class="table">
		<thead>
			<tr>
				<th>Name</th>
				<th>Balance</th>
				<th>Statement</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty accounts}">
				<tr><td colspan="3" class="center">No Accounts to display. Please
					contact the bank.</td></tr>
			</c:if>
			<c:forEach items="${accounts}" var="account">
				<tr>
					<td>$${fn:escapeXml(account.accountId)}</td>
					<td>$${fn:escapeXml(account.accountBalance)}</td>
					<td><a href="statements">View Statements</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>