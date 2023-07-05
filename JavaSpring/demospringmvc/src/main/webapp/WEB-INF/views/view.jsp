<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<h2>VIEW ALL EMPLOYEES</h2>

	<table border="1">

		<th>ID</th>
		<th>FirstName</th>
		<th>LastName</th>
		<th>Email</th>
		<th>Address</th>
		<th>Action</th>

		<c:forEach var="emp" items="${listEmployees}" >
			<tr>
				<td>${emp.id}</td>
				<td>${emp.firstName}</td>
				<td>${emp.lastName}</td>
				<td>${emp.email}</td>
				<td>${emp.add}</td>
			
				<td>Edit | <a href="${pageContext.request.contextPath}/delete/${emp.id}" >Delete</a></td>
				
			</tr>
		</c:forEach>
	</table>

</body>
</html>
