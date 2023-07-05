<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <security:authorize access="hasRole('ROLE_ADMIN')">
       <li><a href="${pageContext.request.contextPath}/admin/adding">Admin</a></li>
       </security:authorize>
       <li><a href="/dtpro/listProducts">Products</a></li>
       <security:authorize access="hasRole('ROLE_ADMIN')">
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
         
        <ul class="dropdown-menu">
          <li><a href="${pageContext.request.contextPath}/admin/showProducts">Products</a></li>
          <li><a href="${pageContext.request.contextPath}/admin/showCategory">Category</a></li>
          <li><a href="${pageContext.request.contextPath}/admin/showSuppliers">Supplier</a></li>
        </ul>
      </li>
      </security:authorize>
    </ul>
     <ul class="nav navbar-nav navbar-right">
     <c:if test="${pageContext.request.userPrincipal.name==null}">
      <li><a href="registerUser"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </c:if>
    
     <c:if test="${pageContext.request.userPrincipal.name!=null}">
      <li><a href="/dtpro/${pageContext.request.userPrincipal.name}/userProfile"><span class="glyphicon glyphicon-user"></span> Welcome ${pageContext.request.userPrincipal.name} </a></li>
      <li><a href="/dtpro/cart">cart</a></li>
      <li><a href="<c:url value="/j_spring_security_logout"/>"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
    </c:if>
    </ul>
    

  </div>
</nav>
  
<div class="container">
  </div>


