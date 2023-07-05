<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>

	<div class="m-5">
		<h3 class="text-center">Student Records</h3>
		<table class="table my-5">
			<thead class="table-dark primary">
				<tr>
					<th scope="col">Roll No.</th>
					<th scope="col">Student Name</th>
					<th scope="col">Email</th>
					<th scope="col">Course</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody class="table-group-divider">
				<c:forEach items="${students }" var="s">
					<tr>
						<td>${s.rollNo }</td>
						<td>${s.stuName }</td>
						<td>${s.stuEmail }</td>
						<td>${s.course }</td>
						<td>
							<a href="delete-student/${s.rollNo }"><i class="fas fa-trash"></i></a>
							<a href="update/${s.rollNo }"><i class="fas fa-pencil"></i></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a class="btn btn-primary" href="register" role="button">Add student</a>
	</div>		
<c:if test="${pageContext.request.userPrincipal.name == null}">
<div class="alert alert-info alert-dismissible fade show position-absolute top-0 start-0" role="alert">
  You have to login first to access the Operations
  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
</div>
</c:if>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>

</body>
</html>