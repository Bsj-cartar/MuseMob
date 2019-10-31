<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Muse Mob - login</title>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<link rel="stylesheet" href="res/css/main.css" />
<style>
.row.gtr-uniform{
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
		<h1>Login</h1>
	</div>

	<!-- Main -->
	<section id="main" class="wrapper">
		<div class="inner">
			<div class="content">
				<div class="row gtr-uniform">
					<!-- Elements -->
					<div class="col-8">
						<h2>Sign in to your account</h2>

						<form method="post" action="#">
							<div class="row gtr-uniform">
								<div><h3>id</h3></div> <input type="text" name="id" id="id" value=""
									/> <div><h3>pass</h3></div> <input type="password"
									name="password" id="password" value="" />
								<div class="col-8">
									<ul class="actions special">

										<li><input type="submit" value="로그인" class="primary fit" /></li>

										<li><button type="button" value="회원가입"
												onclick="location='/login/register'" class="button">회원가입</button></li>
									</ul>
								</div>
							</div>
						</form>
						<div class="col-4" style="background-color: black">hihihihihi</div>

					</div>
				</div>
			</div>
		</div>
	</section>


</body>
</html>

