<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	<div class="container mt-3">
<h3 class="text-center">Update ToDo</h3>
					<form action='<c:url value="/update-todo/${todo.id }"></c:url>' method="post">
						<div class="mb-3">
							<label for="todotitle" class="form-label">Title</label>
								<input type="text" class="form-control"
								id="todotitle" name="title" aria-describedby="emailHelp" placeholder="Type here..."
								value="${todo.title }">
						</div>
						<div class="mb-3">
							<label for="todocontent" class="form-label">Description</label>
							<textarea class="form-control" rows="10"
								id="todocontent" name="content" placeholder="Type here...">${todo.content }</textarea>
						</div>
						<button type="submit" class="btn btn-primary">Update</button>
					</form>
	</div>
</body>
</html>