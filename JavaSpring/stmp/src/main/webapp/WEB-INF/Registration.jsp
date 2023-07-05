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

	<form:form action="login" method="post" modelAttribute="stud">
		<form:input path="name" />
		<form:errors path="name" cssClass="error" />
		<input type="submit" value="Submit">
	</form:form>

</body>
</html>