<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="res/css/Carousel.css" />
</head>
<body>
	<table>
	<tr>
		<td>1</td>
		<td>1</td>
		<td>1</td>
		<td>1</td>
		<td>1</td>
		<td>1</td>
		<td>1</td>
	</tr>
	<c:forEach var="musemob" items="${musemobs}">
		<tr>
			<td>${musemob.musemobid}</td>
			<td>${musemob.championpost.postid}</td>
			<td>${musemob.championpost.posttitle}</td>
			<td>${musemob.championpoint}</td>
			<td>${musemob.challengerpost.postid}</td>
			<td>${musemob.challengerpost.posttitle}</td>
			<td>${musemob.challengerpoint}</td>
		</tr>
	</c:forEach>
	
	</table>
</body>
</html>