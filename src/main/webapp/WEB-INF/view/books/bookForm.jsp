<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Upload Book</title>
</head>

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

<body>

	<br />
	<div class="section-1-container section-container">
		<div class="container h-100">
			<div class="row h-100 justify-content-center align-items-center">
				<div class=" col-10 col-md-5 col-lg-4r">
					<h1 align="center">Upload <span class="badge badge-secondary">Book</span></h1>

					<form:form action="uploadBook" modelAttribute="book" enctype="multipart/form-data" method="POST">

						<c:if test="${not empty error}">
							<div class="alert alert-danger" role="alert">${error}</div>
						</c:if>

						<div class="form-group"><label for="bookName">Book
								Name(*)</label> <form:input path="bookName" type="text"
								cssClass="form-control" /> <form:errors path="bookName"
								cssClass="error" /></div>

						<div class="form-group"><label for="subCode">Subject
								Code(*)</label> <form:input path="subjectCode" type="text"
								cssClass="form-control" /> <form:errors path="subjectCode"
								cssClass="error" /></div>

						<div class="form-group"><label for="branch">Branch(*)</label>
							<form:select class="form-control" path="branch">
								<form:option value="COMP" label="Computer Engineering" />
								<form:option value="EE" label="Electrical Engineering" />
								<form:option value="ECC"
									label="Electrical And Communication Engineering" />
								<form:option value="MECH" label="Mechanical Engineering" />
								<form:option value="CIVIL" label="Civil Engineering" />
								<form:option value="CHE" label="Chemical Engineering" />
							</form:select> <form:errors path="branch" cssClass="error" /></div>

						<div class="form-group"><label for="sem">Semester(*)</label>
							<form:select class="form-control" path="semester">
								<form:option value="1" label="1" />
								<form:option value="2" label="2" />
								<form:option value="3" label="3" />
								<form:option value="4" label="4" />
								<form:option value="5" label="5" />
								<form:option value="6" label="6" />
								<form:option value="7" label="7" />
								<form:option value="8" label="8" />
							</form:select> <form:errors path="semester" cssClass="error" /></div>

						<div class="form-group"><label for="edition">Book
								Edition(*)</label> <form:select class="form-control" path="bookEdition">
								<form:option value="1" label="1" />
								<form:option value="2" label="2" />
								<form:option value="3" label="3" />
								<form:option value="4" label="4" />
								<form:option value="5" label="5" />
								<form:option value="6" label="6" />
								<form:option value="7" label="7" />
								<form:option value="8" label="8" />
								<form:option value="9" label="9" />
								<form:option value="10" label="10" />
							</form:select> <form:errors path="bookEdition" cssClass="error" /></div>

						<div class="form-group"><form:hidden path="uploaderId"
								value="${id}" cssClass="form-control" /> <form:errors
								path="uploaderId" cssClass="error" /></div>

						<div class="form-group"><label for="exampleFormControlFile1">Example
								file input</label> <input type="file" class="form-control-file"
							id="exampleFormControlFile1"></div>

						<button type="submit" class="btn btn-primary">Submit</button>

					</form:form>

			</div>
		</div>
	</div>
</div>

</body>
</html>