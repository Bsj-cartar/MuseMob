<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
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
		<h1>Video Post</h1>
	</div>
	
	<section id="main" class="wrapper">
				<div class="inner">
					<div class="content">
						<header>
							<h2>${boardContent.posttitle}</h2>
						</header>
						<hr>
						
						<code>${boardContent.uid}</code>
						
						<section>
							<div class="content">
								<header>
									<div class="video">
										<iframe src="http://www.youtube.com/embed/${boardContent.postvideourl}" frameborder="0"
										allow="autoplay;" allowfullscreen>
									</iframe>
									</div>
								</header>	
							</div>
						</section>
						<div class="postactions">
							<ul class="actions">
								<c:if test="${boardContent.uid eq login}">
									<li><a href="${boardContent.postid}/update" class="button small">수정</a></li>
									<li><a href="${boardContent.postid}/delete" class="button small">삭제</a></li>	
								</c:if>
								
									<li><a href="/board/${beforeInstSection}" class="button small">목록</a></li>
								
									<li><a href="#Redirect" onClick="getPostId(<c:out value="${list.postid}"/>)" class="button primary small museMob">대전 신청</a></li>
								
								
							</ul>
						</div>
						
						<!-- The Modal -->
						<div id="myModal" class="modal">
						
							<!-- Modal content -->
							<div class="modal-content">
								<span class="close">&times;</span>
								<h2>정말 대전을 신청하시겠습니까 ?</h2>
								<h3>포인트가 100점 차감됩니다.</h3>
								<p>최근 동영상 중 대전에 참가할 동영상을 선택해주세요.</p>
						
								<form action="/board/${inst}/newchallenger" method="post">
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
									<input id="championPostid"type="hidden" name="champion" value="${boardContent.postid}"/>
									<input type="submit" value="대전 신청!" class="primary">
								</form>
							</div>
						</div>
						
					</div>
				</div>
			</section>
	

</body>
<script>
// Get the modal
var modal = document.getElementById('myModal');


// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks on the button, open the modal

	
function getPostId(postid) {
	
	
	modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
  modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}

</script>


<!-- Scripts -->
<script src="/res/js/jquery.min.js"></script>
<script src="/res/js/browser.min.js"></script>
<script src="/res/js/breakpoints.min.js"></script>
<script src="/res/js/util.js"></script>
<script src="/res/js/main.js"></script>



</html>
</html>