<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
	<h1>Hello my app!</h1>
	<p>Welcome</p>
	<a href="${pageContext.request.contextPath}/register">signup</a>
	<a href="${pageContext.request.contextPath}/all">get all employees</a>
</body>
</html>
