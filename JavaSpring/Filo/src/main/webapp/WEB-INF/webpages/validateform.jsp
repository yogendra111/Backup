<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.error{
		color: 'red';
	}
</style>
</head>
<body>

	<form:form action="login" method="post" modelAttribute="user">
	<table>
		<tr>
			<td><form:label path="name">Username</form:label></td>
			<td><form:input path="name" /></td>
			<td><form:errors path="name" cssClass="error" /></td>
		</tr>
		<tr>
			<td><form:label path="email">Email</form:label></td>
			<td><form:input path="email" /></td>
			<td><form:errors path="email" cssClass="error" /></td>
		</tr>
		<tr>
			<td><form:label path="password">Password</form:label></td>
			<td><form:input path="password" /></td>
			<td><form:errors path="password" cssClass="error" /></td>
		</tr>
	</table>
		<input type="submit" value="Submit">
	</form:form>

</body>
</html>