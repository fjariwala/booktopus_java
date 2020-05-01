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

<title>Book Information</title>
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

			</ul>
				<form class="form-inline my-2 my-lg-0"><input
					class="form-control mr-sm-2" type="search" placeholder="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
	</nav>
</div>
	<!-- Navbar Ends -->

	<!-- Book Component Starts-->
	<br />
	<br />
	<div class="container">
		<!-- Content here --> <!-- Columns start at 50% wide on mobile and bump up to 33.3% wide on desktop -->
		<div class="row">

			<div class="col-xs-6 col-md-3 "><br />
				<div class="card" style="width: 16rem;"><img
					src="/Booktopus/resources/uploads/${book.imageName }" height="319px"
					class="card-img-top" alt="...">

					<div class="card-body">
						<h5 class="card-title">${book.bookName }</h5>
						<p class="card-text">${book.subjectCode }</p> <a href="*"
						class="btn btn-primary">Request</a>

				</div></div></div>
	</div>

</div>

	</div>

	<!-- Book Component Ends -->

</body>
</html>