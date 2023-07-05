<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
</head>
<body>

<div class="d-flex justify-content-center">
<div class="card mb-3" style="max-width: 540px;">
  <div class="row g-0">
    <div class="col-md-4">
      <img src="https://r1.ilikewallpaper.net/iphone-14-wallpapers/download-119699/rocky-mountain-national-park-hd.jpg" class="img-fluid rounded-start" alt="...">
    </div>
    <div class="col-md-8">
      <div class="card-body">
        <h2 class="card-title mb-4">Login</h2>
			<form:form method="post" action="user_login">
			
    			<div class="mb-3">
    			  <label for="uname" class="form-label">Username</label>
    			  <input type="text" name="username" class="form-control" id="uname"/>
    			</div>
    			<div class="mb-3">
    			  <label for="pswd" class="form-label">Password</label>
    			  <input type="text" name="password" class="form-control" id="pswd"/>
    			</div>
				
    			<input required type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
                <input id="btn-login" type="submit" value="Login" class="btn btn-success mt-3"></input>
			</form:form>
      </div>
            <c:if test="${not empty error || not empty logout}">
            	<p class="text-danger text-center">
             		${error }
             		${logout }
             	</p>
            </c:if>
    </div>
  </div>
</div>
</div>

</body>
</html>