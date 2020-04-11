<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

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
				<div class=" col-10 col-md-5 col-lg-5r">
					<h1 align="center">Account <span class="badge badge-secondary">Registration</span></h1>

					<form:form action="register" modelAttribute="user" method="POST">

						<c:if test="${not empty error}">
							<div class="alert alert-danger" role="alert">${error}</div>
						</c:if>

						<div class="form-group"><label for="firstName">First
								Name(*)</label> <form:input path="firstName" type="text"
								cssClass="form-control" /> <form:errors path="firstName"
								cssClass="error" /></div>

						<div class="form-group"><label for="lastName">Last
								Name(*)</label> <form:input path="lastName" type="text"
								cssClass="form-control" /> <form:errors path="lastName"
								cssClass="error" /></div>

						<div class="form-group"><label for="exampleInputEmail1">Email
								address(*)</label> <form:input path="email" type="email"
								cssClass="form-control" /> <small id="emailHelp"
							class="form-text text-muted">We'll never share your email
								with anyone else.</small> <form:errors path="email" cssClass="error" />
						</div>

						<div class="form-group"><label for="phone">Telephone
								Number(*)</label> <form:input path="phone" type="text"
								cssClass="form-control" /> <form:errors path="phone"
								cssClass="error" /></div>

						<div class="form-group"><label for="pass1">Password(*)</label>
							<form:input path="password" type="password"
								cssClass="form-control" /> <form:errors path="password"
								cssClass="error" /></div>

						<!-- 	<div class="form-group">
							<label for="pass2">Confirm Password</label>
							<form:input path="password" type="password"
								cssClass="form-control" />
						</div>
 -->

						<div class="form-group form-check"><input type="checkbox"
							class="form-check-input" id="exampleCheck1" /> <label
							class="form-check-label" for="exampleCheck1">Check me out</label>
						</div>

						<button type="submit" class="btn btn-primary">Submit</button>
					</form:form>

			</div>
		</div>
	</div>
</div>
</body>
</html>