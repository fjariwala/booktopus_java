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

<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">
<script src="https://kit.fontawesome.com/0b1d7c9201.js"
	crossorigin="anonymous"></script>

<title>Book Information</title>
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
									href="/Booktopus/book/uploadBook">Upload Book</a> <a
									class="dropdown-item" href="/Booktopus/user/userRequests">Your
										Requests</a>
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

	<!-- Book Component Starts-->
	<c:if test="${not empty notificationIsSetOrNot}">
		<div class="alert alert-success" role="alert">${notificationIsSetOrNot}</div>
	</c:if>

	<br />
	<br />
	<div class="container">
	
		<c:url var="getReqLink" value="/book/reqForBook">
			<c:param name="bookId" value="${book.id }"></c:param>
		</c:url>
		
		 <!-- Content here --> 
		 <!-- Columns start at 50% wide on mobile and bump up to 33.3% wide on desktop -->
		 
		 <!-- 
				<div class="row">
		
					<div class="col-md-8"><br />
						<div class="card" style="width: 22rem;"><img
							src="/Booktopus/resources/uploads/${book.imageName }"
							height="450px" width="350px" class="card-img-top" alt="..."></div>
				</div>
					<div class="col-md-6">
		
						<h5>Name : ${book.bookName }</h5>
						<p>Subject Code : ${book.subjectCode }</p> <a href="${ getReqLink}"
						class="btn btn-primary">Request</a>
		
				</div>
			</div>

 		-->
 		
 		<!-- New Book CSS Starts -->
 		<br />
 		<br />
 		 <div class="row">
          
                <div class="col-lg-6">
                
                    <img src="/Booktopus/resources/uploads/${book.imageName }" width="400px" height="500px">
                </div>
                <div class="col-lg-6">
                    <h2>Book Title:${book.bookName}</h2>
                    <br>
                    <p>Book Author :${book.bookAuthor} </p>
                    <p>Book Edition : ${book.bookEdition}</p>
                    <p>Subject code : ${book.subjectCode}</p>
                    <p>Uploaded By : ${uploaderName }</p>
                	<p>Contact Number : ${contactNumber }</p>
                    <div class="row">
                       
                        <div class="col-lg-6">
                        
                        <a href="${ getReqLink}">
                            <button type="button" name="submit" class="btn btn-success btn-block bg-success"style="height:50px;"><i
                                                class="fas fa-check"></i>Request</button>
                        </a>
                        
                        </div>
                    </div>
                </div>
            
          
            </div>
 		
 		<!-- New Book CSS Ends -->
 		
		</div>
	<!-- Book Component Ends -->

</body>
</html>