<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<title>Login</title>
<body style="background-color: #EEEEEE;">
	<div class="container">
		<div id="loginbox" style="margin-top: 50px;"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Log In</div>
					<div
						style="float: right; font-size: 80%; position: relative; top: -10px">
						<a href="#">Forgot password?</a>
					</div>
				</div>

				<div style="padding-top: 30px" class="panel-body">

					<div style="display: none" id="login-alert"
						class="alert alert-danger col-sm-12"></div>
					<form:form method="post" modelAttribute="emp1" action="save"
						name="loginform" class="form-horizontal" role="form">

						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-lock"></i></span>
							<form:input id="login-password" type="text" class="form-control"
								name="firstName" placeholder="Employee first name"
								path="firstName" />
								
								<form:errors id="login-password" type="text" class="form-control"
								name="firstName" placeholder="Employee first name"
								path="firstName" />
						</div>

						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-lock"></i></span>
							<form:input id="login-password" type="text" class="form-control"
								name="lastName" placeholder="Employee last name" path="lastName" />
								
								 <form:errors id="login-password" type="text" class="form-control"
								name="lastName"
								path="lastName" /> 
						</div>

						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-lock"></i></span>
							<form:input id="login-password" type="email" class="form-control"
								name="email" placeholder="email" path="email" />
						</div>
						
						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-lock"></i></span>
							<form:input id="login-password" type="text" class="form-control"
								name="add" placeholder="add" path="add" />
						</div>

						<div style="margin-top: 10px" class="form-group">
							<!-- Button -->

							<div class="col-sm-12 controls">
								<button id="btn-login" type="submit" value="Login"
									class="btn btn-success">Save</button>

							</div>
						</div>

					</form:form>
				</div>
			</div>
		</div>
	</div>
	</div>