<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

.Container {
margin: 40px;
display: flex;
justify-content:space-between;
}

.testGrid {
display: flex;
flex-direction: row;
padding: 50px;
border: 1px solid black;
}
</style>
</head>
<body>
<div class="Container">
	<div class="testGrid">1</div>
	<div class="testGrid">
		<div class="testGrid">2</div>
		<div class="testGrid">3</div>
		<div class="testGrid">4</div>
	
	</div>
	
</div>
</body>
</html>