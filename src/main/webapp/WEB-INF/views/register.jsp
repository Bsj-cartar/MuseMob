<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


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
<script src='http://code.jquery.com/jquery-3.3.1.min.js'></script>
<style>
.row.gtr-uniform {
	justify-content: center;
}
</style>
</head>
<body class="is-preload">
	<!-- Header 파일 include -->
	<%@ include file="commons/header.jspf"%>

	<!-- Heading -->
	<div id="heading">
		<h1>회원가입</h1>
	</div>

	<!-- Main -->
	<section id="main" class="wrapper">

		<div class="inner">
			<div class="content">
				<form action="/login/registerAccount" method="post">
						<div class="row gtr-uniform special">
						
							<div class="col-12">
								<h2>회원가입을 환영합니다.</h2>
								<h3>서로에게 자신의 실력을 보여주고, 대결하며 포인트를 쌓읍시다.</h3>
							</div>


							<div class="col-2">
								<h3>아이디</h3>
							</div>
							<div class="col-8">
								<input type="text" id="uid" name="uid" />
								<p class="result">
									<span class="msg"></span>
								</p>

							</div>
							<div class="col-2">
								<button type="button" class="idCheck button primary">아이디확인</button>
							</div>


							<div class="col-2">
								<h3>비밀번호</h3>
							</div>
							<div class="col-10">
								 <input type="password" id="upw" name="upw" />
							</div>
							
							
							<div class="col-2">
								<h3>이름</h3>
							</div>
							<div class="col-10">
								<input type="text" name="uname" id="uname" />
							</div>
							
							
							<div class="col-2">
								<h3>E-메일</h3>
							</div>
							<div class="col-10">
								<input type="text" name="uemail" id="uemail" />
							</div>
							
							<div class="col-12">
								<ul class="actions special ">
									<li><input type="submit" id="submit"
										class="button primary fit" value="회원가입" disabled="disabled"></li>
								</ul>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>

	<script>
		$(".idCheck").click(function() {
			var query = {
				uid : $("#uid").val()
			};
			$.ajax({
				url : "idCheck",
				type : "post",
				data : query,
				success : function(data) {

					if (data == 1) {
						$(".result .msg").text("사용 불가");
						$(".result .msg").attr("style", "color:#ff0000");

						$("#submit").attr("disabled", "disabled");
					} else {
						$(".result .msg").text("사용 가능");
						$(".result .msg").attr("style", "color:#0000ff");

						$("#submit").removeAttr("disabled");
					}
				}
			})
		});
	</script>
</body>
</html>