<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ToDO's</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	<div class="container mt-3">
		<h1 class="text-center">
			Welcome
			<c:out value="${username }"></c:out>
		</h1>
		<% if(request.getAttribute("msg")!=null){ %>
		<c:if test="${not empty msg }">
			<div class="alert alert-success">
				<b><c:out value="${msg }"></c:out></b>
			</div>
		</c:if>
		<% } %>
		<div class="row mt-5">
			<div class="col-md-3">
				<div class="list-group">
					<button type="button"
						class="list-group-item disabled" aria-disabled="true"
						>Menu</button>
					<a class="list-group-item list-group-item-action"
						href='<c:url value="/view-todo"></c:url>'>View Todo's</a> <a
						class="list-group-item list-group-item-action"
						href='<c:url value="/add-todo"></c:url>'>Add Todo</a>
				</div>
			</div>
			<div class="col-md-8">

				<c:if test="${page=='viewToDo' }">
					<h3 class="text-center">All ToDo's</h3>
					<table class="table">
  <thead class="table-dark">
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Title</th>
      <th scope="col">Description</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody class="table-group-divider">
    <c:forEach items="${todos }" var="t">
    <tr>
      <th scope="row">${t.id }</th>
      <td>${t.title }</td>
      <td>${t.content }</td>
      <td>
      	<a href="delete-todo/${t.id }"><i class="fas fa-trash text-danger"></i></a>
      	<a href="update/${t.id }"><i class="fas fa-pencil"></i></a>
      </td>
    </tr>
    </c:forEach>
  </tbody>
</table>
				</c:if>
				<c:if test="${page=='addToDo' }">
					<h3 class="text-center">Add ToDo</h3>
					<form action='<c:url value="/save-todo"></c:url>' method="post">
						<div class="mb-3">
							<label for="todotitle" class="form-label">Title</label>
								<input type="text" class="form-control"
								id="todotitle" name="title" aria-describedby="emailHelp" placeholder="Type here...">
						</div>
						<div class="mb-3">
							<label for="todocontent" class="form-label">Description</label>
							<textarea class="form-control" rows="10"
								id="todocontent" name="content" placeholder="Type here..."></textarea>
						</div>
						<button type="submit" class="btn btn-primary">Add</button>
					</form>
				</c:if>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>