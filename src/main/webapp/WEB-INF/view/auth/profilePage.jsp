<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

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

<title>Profile Page</title>
</head>
<body>

	<!-- Navbar starts -->
	<div class="container">
		<nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark">
			<a class="navbar-brand" href="/Booktopus/home">Booktopus</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarTogglerDemo02"
			aria-controls="navbarTogglerDemo02" aria-expanded="false"
			aria-label="Toggle navigation"><span
				class="navbar-toggler-icon"></span></button>

			<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
				<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
					<li class="nav-item active"><a class="nav-link"
						href="/Booktopus/home"> Home <span class="sr-only">(current)</span>
					</a></li>

					<c:choose>

						<c:when test="${not empty user}">

							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
								role="button" data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false">${user }</a>
								<div class="dropdown-menu" aria-labelledby="navbarDropdown">
									<a class="dropdown-item" href="/Booktopus/user/profile">Profile</a>
									<a class="dropdown-item" href="/Booktopus/user/pendingRequests">Pending
										Requests</a> <a class="dropdown-item"
									href="/Booktopus/user/userRequests">Your Requests</a> <a
									class="dropdown-item" href="/Booktopus/book/uploadBook">Upload
										Book</a>
									<div class="dropdown-divider"></div> <a class="dropdown-item"
									href="/Booktopus/user/logout">Logout</a>
							</div></li>

						</c:when>

						<c:otherwise>
							<li class="nav-item active"><a class="nav-link"
								href="/Booktopus/user/login">Login</a></li>
							<li class="nav-item active"><a class="nav-link"
								href="/Booktopus/user/register">Register</a></li>
						</c:otherwise>

					</c:choose>

			</ul>
				<form class="form-inline my-2 my-lg-0" method="post"
				action="/Booktopus/book/search"><input
					class="form-control mr-sm-2" type="search" name="strVal"
					placeholder="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
	</nav>
</div>
	<!-- Navbar Ends -->

	<!-- Pending request table Starts -->
	<div class="container"><br /> <br /> <br />
		<div class="alert alert-primary justify-content-center" role="alert">Your
			uploaded books will be visible here once you upload the book</div>
		
		
		<c:choose>

				<c:when test="${not empty books}">
				
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">Book Id</th>
							<th scope="col">Book Name</th>
							<th scope="col">Book Author</th>
							<th scope="col">Subject Code</th>
							<th scope="col">Branch</th>
							<th scope="col">Semester</th>
							<th scope="col">Book Edition</th>
						</tr>
					</thead>
				
					<c:forEach var="book" items="${ books}">
				
						
						
							<tbody>
								<tr>
									<th scope="row">${book.id }</th>
									<td>${book.bookName }</td>
									<td>${book.bookAuthor }</td>
									<td>${book.subjectCode }</td>
									<td>${book.branch }</td>
									<td>${book.semester }</td>
									<td>${book.bookEdition }</td>
									
							</tr>
							</tbody>
						</c:forEach>
				</table>
				
				</c:when>
		
				<c:otherwise>
					<br />
					<br />
					<h5>You haven't uploaded any books yet.</h5>
				</c:otherwise>
				
		</c:choose>

</div>	
	<!-- Pending request table Ends -->

</body>
</html>