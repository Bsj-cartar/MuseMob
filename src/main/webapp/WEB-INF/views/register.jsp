<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>


<!DOCTYPE html>
<html>
<head>
<title>Muse Mob - login</title>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<link rel="stylesheet" href="../res/css/main.css" />
<style>
.row.gtr-uniform {
justify-content: center;
}
</style>
</head>
<body class="is-preload">
	<!-- Header -->
	<header id="header">
		<a class="logo" href="/">MuseMob</a>
		<nav>
			<a href="login">Login</a> <a href="#menu">Menu</a>
		</nav>
	</header>

	<!-- Nav -->
	<nav id="menu">
		<ul class="links">
			<li><a href="login">Login</a></li>
			<li><a href="elements">Elements</a></li>
			<li><a href="generic">Generic</a></li>
		</ul>
	</nav>

	<!-- Heading -->
	<div id="heading">
		<h1>Register</h1>
	</div>

	<!-- Main -->
	<section id="main" class="wrapper">

		<div class="inner">
			<div class="content">

				<!-- Elements -->
				<div class="row ">

					
					<form action="/login/registerAccount" method="post">
						<div class="row gtr-uniform special">
							<h2>Please give us more information</h2>
							<h3>Tell us a bit more about yourself and the music you like!</h3>


							<div class="col-10">
								<span>id</span> 
								<input type="text" id="id" name="id"/>
							</div>
							<div class="col-10">
								<span>pass</span> 
								<input type="password" id="password" name="password"/>
							</div>
							<div class="col-10">
								<span>name</span> 
								<input type="text" name="name" id="name"/>
							</div>
							<div class="col-10">
								<span>email</span> 
								<input type="text" name="email" id="email" />
							</div>
							<div class="col-10">
								<ul class="actions special ">
									<li><input type="submit" class="button primary fit" value="회원가입" ></li>
								</ul>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>


</body>
</html>