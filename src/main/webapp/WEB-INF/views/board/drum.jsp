<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Muse Mob</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<meta name="description" content="" />
<meta name="keywords" content="" />

<link rel="stylesheet" href="/res/css/main.css" />
</head>
<body class="is-preload">

	<!-- Header 파일 include -->
	<%@ include file="../commons/header.jspf"%>

	<!-- Heading -->
	<div id="heading">
		<h1>Drum</h1>
	</div>

	<section id="cta">
	
	<div class="slides">
		<div class="row">
			<a class="prev" onclick="plusSlides(-1)">&#10094;</a> 
			<a class="next" onclick="plusSlides(1)">&#10095;</a>
			
			
			<c:forEach var="musemob" items="${musemobs}">
				<div class="slides_content_left col-6 col-12-small">
					<div class="slides_content">
						
						<a href="post/${musemob.championpost.postid}"> 
						<img src="http://i.ytimg.com/vi/${musemob.championpost.postvideourl}/0.jpg" />
						</a>
						
					</div>
					
					<a href="drum/${musemob.musemobid }/chapmchoice" class="chapmchoice button small">응원하기</a>
					<%-- <button onclick="javascript:chapmchoice('${championpost.uid}')" class="chapmchoice button small">응원하기</button> --%>

				</div>
				<div class="slides_content_right col-6 col-12-small">
					<div class="slides_content">
						
						<a href="post/${musemob.challengerpost.postid}"> 
						<img src="http://i.ytimg.com/vi/${musemob.challengerpost.postvideourl}/0.jpg" />
						</a>
						
					</div>
					
					<a href="drum/${musemob.musemobid }/challchoice" class="challchoice button small">응원하기</a>
				</div>
			</c:forEach>
			 
		</div>
	</div>
		
	</section>
	
	<section class="wrapper">
		<div class="inner">
			<header class="special">
				<h2>공유한 동영상으로 대결해서 포인트를 획득하세요!</h2>
				<p>대결하고 싶은 동영상에 대결 신청을 눌러보세요. <br> 
				최근에 공유한 동영상 세 개 중 하나를 선택해서 경쟁할 수 있습니다. <br> 
				게시판 상단에 노출 되어 다른 회원들에게 응원받을 수 있습니다. <br>
				더 많이 응원을 받은 사람이 포인트를 몽땅 가져가겠죠 ?</p>
				<a href="postupload" class="button primary large">업로드</a>
			</header>
			<div class="highlights">
				<c:forEach var="list" items="${list}" varStatus="vs">

					<section>
						<div class="content">
							<header>
								<div class="video">
									
									<a href="post/${list.postid }"> 
									<img src="http://i.ytimg.com/vi/${list.postvideourl}/mqdefault.jpg" />
									</a>

								</div>

							</header>
							<div class="videotitle">
								<a href="post/${list.postid }">
									<h3>${list.posttitle }</h3>
								</a>
							</div>

							<div id="getpostid" style="display:none">${list.postid}</div>
							
							<ul class="actions">
								<li><a href="#" class="button small"
									onClick="fn_contentView(<c:out value="${list.postid}"/>)">상세보기</a></li>
								<li><a href="drum/${list.postid}/support" class="button small">후원하기</a>
								<li><a href="#Redirect" onClick="getPostId(<c:out value="${list.postid}"/>)" class="button primary small">대결 신청</a></li>
								
							</ul>
						</div>
					</section>
					
				</c:forEach>
			</div>
		</div>
	</section>
	
	
	<!-- The Modal -->
	<div id="myModal" class="modal">
	
		<!-- Modal content -->
		<div class="modal-content">
			<span class="close">&times;</span>
			<h2>정말 대전을 신청하시겠습니까 ?</h2>
			<h3>포인트가 100점 차감됩니다.</h3>
			<p>최근 동영상 중 대전에 참가할 동영상을 선택해주세요.</p>
	
			<form action="drum/newchallenger" method="post">
				<div>
					<c:forEach var="recentlyPost" items="${recentlyPostInst}">
						<input type="radio" id="radio-${recentlyPost.postid}"
							name="challenger" value="${recentlyPost.postid}">
						<label for="radio-${recentlyPost.postid}">
						<iframe src="http://www.youtube.com/embed/${recentlyPost.postvideourl}?controls=2showinfo=0"
								frameborder="0" allow="autoplay;" allowfullscreen> </iframe>
						</label>
					</c:forEach>
				</div>
				<input id="championPostid"type="hidden" name="champion" value=""/>
				<input type="submit" value="대전 신청!" class="primary">
			</form>
		</div>
	</div>


	<div class="page-move-btn">
		<ul>
			<c:if test="${pageMaker.prev }">
				<li><a
					href='<c:url value="/board/drum?page=${pageMaker.startPage-1}"/>'>PREV</a></li>

			</c:if>
			<c:forEach begin="${pageMaker.startPage }"
				end="${pageMaker.endPage }" var="idx">
				<c:choose>

					<c:when test="${idx==page}">
						<li><a class="currentPage"
							href='<c:url value="/board/drum?page=${idx }"/>'>${idx }</a></li>
					</c:when>
					<c:otherwise>
						<li><a href='<c:url value="/board/drum?page=${idx }"/>'>${idx }</a></li>
					</c:otherwise>


				</c:choose>
			</c:forEach>
			<c:if test="${pageMaker.next && pageMaker.endPage >0 }">
				<li><a
					href='<c:url value="/board/drum?page=${pageMaker.endPage+1 }"/>'>NEXT</a></li>
			</c:if>
		</ul>
	</div>

	




</body>
<script> 
function fn_contentView(post){

	var url = "post/";
	url = url + post;
		
	location.href = url;
	
}
</script>
<script>
		var slideIndex = 1;
		showSlides(slideIndex);

		function plusSlides(n) {
			showSlides(slideIndex += n);
		}

		function currentSlide(n) {
			showSlides(slideIndex = n);
		}

		function showSlides(n) {
			var i;
			var slides_left = document.getElementsByClassName("slides_content_left");
			var slides_right = document.getElementsByClassName("slides_content_right");
			
			if (n > slides_left.length) {
				slideIndex = 1
			}
			if (n > slides_right.length) {
				slideIndex = 1
			}
			if (n < 1) {
				slideIndex = slides_left.length
			}
			for (i = 0; i < slides_left.length; i++) {
				slides_left[i].style.display = "none";
				slides_right[i].style.display = "none";
			}
			
			slides_left[slideIndex - 1].style.display = "block";
			slides_right[slideIndex - 1].style.display = "block";
			
		}


</script>
<script> function btnalert(sample){ alert(sample); } </script>

<!-- Scripts -->
<script src="/res/js/jquery.min.js"></script>
<script src="/res/js/browser.min.js"></script>
<script src="/res/js/breakpoints.min.js"></script>
<script src="/res/js/util.js"></script>
<script src="/res/js/main.js"></script>

<script src="/res/js/museMobModal.js"></script>

</html>