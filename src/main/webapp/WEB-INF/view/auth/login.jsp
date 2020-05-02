<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>


<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>


<style>
.error {
	color: red
}
</style>

</head>
<body>

	<br />
	<div class="section-1-container section-container">
		<div class="container h-100">
			<div class="row h-100 justify-content-center align-items-center">
				<div class=" col-10 col-md-5 col-lg-4r">
					<h1 align="center">Account <span class="badge badge-secondary">Login</span></h1>

					<form:form action="login" modelAttribute="user" method="POST">

						<c:if test="${not empty error}">
							<div class="alert alert-danger" role="alert">${error}</div>
						</c:if>

						<div class="form-group"><label for="exampleInputEmail1">Email
								address(*)</label> <form:input path="email" type="email"
								cssClass="form-control" /> <small id="emailHelp"
							class="form-text text-muted">We'll never share your email
								with anyone else.</small> <form:errors path="email" cssClass="error" />
						</div>

						<div class="form-group"><label for="pass1">Password(*)</label>
							<form:input path="password" type="password"
								cssClass="form-control" /> <form:errors path="password"
								cssClass="error" /></div>

						<button type="submit"
							class="btn btn-outline-primary btn-lg btn-block">Submit</button>

						<div class="alert alert-light" role="alert">If you are not
							registered <a href="register">Click here, </a> to go to
							registration page

						</div>
					</form:form>

			</div>
		</div>
	</div>
</div>

</body>
</html>