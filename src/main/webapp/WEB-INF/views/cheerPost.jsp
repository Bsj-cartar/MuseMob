<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
	alert("5포인트를 사용하여 응원했습니다~");
	
	self.location = "/board/".concat("${inst}");
</script>
</body>
</html>