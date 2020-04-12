<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booktopus</title>

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

</head>
<body>
	<!-- Navbar starts -->
	<div class="container">
		<nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark">
			<a class="navbar-brand" href="#">Booktopus</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarTogglerDemo02"
			aria-controls="navbarTogglerDemo02" aria-expanded="false"
			aria-label="Toggle navigation"><span
				class="navbar-toggler-icon"></span></button>

			<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
				<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
					<li class="nav-item active"><a class="nav-link" href="home">
							Home <span class="sr-only">(current)</span>
					</a></li>

					<c:choose>

						<c:when test="${not empty user}">

							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
								role="button" data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false">${user }</a>
								<div class="dropdown-menu" aria-labelledby="navbarDropdown">
									<a class="dropdown-item" href="user/profile">Profile</a> <a
									class="dropdown-item" href="book/uploadBook">Upload Book</a>
									<div class="dropdown-divider"></div> <a class="dropdown-item"
									href="user/logout">Logout</a>
							</div></li>

						</c:when>
						<c:otherwise>
							<li class="nav-item active"><a class="nav-link"
								href="user/login">Login</a></li>
							<li class="nav-item active"><a class="nav-link"
								href="user/register">Register</a></li>
						</c:otherwise>

					</c:choose>

			</ul>
				<form class="form-inline my-2 my-lg-0"><input
					class="form-control mr-sm-2" type="search" placeholder="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
	</nav>
</div>
	<!-- Navbar Ends -->

	<!-- Book container starts -->
	<br />
	<br />
	<div class="container ">
		<!-- Columns start at 50% wide on mobile and bump up to 33.3% wide on desktop -->
		<div class="row">

			<div class="col-xs-6 col-md-4 "><br />
				<div class="card" style="width: 18rem;"><img
					src="resources/images/ada.jpg" height="350px" class="card-img-top"
					alt="...">
					<div class="card-body">
						<h5 class="card-title">Card title</h5>
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p> <a
						href="#" class="btn btn-primary">Go somewhere</a>
				</div></div></div>

			<div class="col-xs-6 col-md-4"><br />
				<div class="card" style="width: 18rem;"><img
					src="resources/images/se.jpg" height="350px" class="card-img-top"
					alt="...">
					<div class="card-body">
						<h5 class="card-title">Card title</h5>
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p> <a
						href="#" class="btn btn-primary">Go somewhere</a>
				</div></div></div>

			<div class="col-xs-6 col-md-4"><br />
				<div class="card" style="width: 18rem;"><img
					src="resources/images/maths.jpg" height="350px"
					class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">Card title</h5>
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p> <a
						href="#" class="btn btn-primary">Go somewhere</a>
				</div></div></div>

			<div class="col-xs-6 col-md-4"><br />
				<div class="card" style="width: 18rem;"><img
					src="resources/images/maths.jpg" height="350px"
					class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">Card title</h5>
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p> <a
						href="#" class="btn btn-primary">Go somewhere</a>
				</div></div></div>

	</div>
</div>

	<!-- Book container ends -->

</body>
</html>