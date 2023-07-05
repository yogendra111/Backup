<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file = "templates/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head> 
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css">

		<!-- Website CSS style -->
		<link rel="stylesheet" type="text/css" href="assets/css/main.css">

		<!-- Website Font style -->
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
		
		<!-- Google Fonts -->
		<link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
		<link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>

		<!-- <title>Admin</title> -->
	</head>
	<body>
	<div class="container">
		<form:form action="saveUser" modelAttribute="user" method="post" enctype="multipart/form-data">
    <div class="form-group">
      <label for="email">User Name:</label>
      <form:input path="uName" type="text" class="form-control" id="email" placeholder="user name"/>
    </div>
    <div class="form-group">
      <label for="email">Email</label>
      <form:input path="email" type="text" class="form-control" id="email" placeholder="enter your email"/>
    </div>
    <div class="form-group">
      <label for="email">Password</label>
      <form:input path="password" type="password" class="form-control" id="email" placeholder="enter your password"/>
    </div>
    <div class="form-group">
      <label for="email">Role</label>
      <form:input path="role" type="text" class="form-control" id="email" placeholder="specify your role"/>
    </div>
    
    <div class="form-group">
      <label for="email">Profile Pic</label>
      <input type="file" class="form-control" id="email" name="uPic" placeholder="specify your role"/>
    </div>
    
    <div class="form-group">
      <label for="email">Phone</label>
      <form:input path="phone" type="text" class="form-control" id="email" placeholder="enter contact number"/>
    </div>
    
    
	<!-- <div class="form-group">
      <label for="email">Product Picture:</label>
      <input type="file" class="form-control" id="email" placeholder="image name" name="pfile"/>
    </div> -->

    <button type="submit" class="btn btn-default">Submit</button>
  </form:form>
</div>

	</body>
</html>
<%@ include file = "templates/footer.jsp" %>