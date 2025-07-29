<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>JSP 예제 - include.jsp</title>
	<link href="../image/icon.png" rel="icon" type="image/x-icon" />
	</head>
	<body>
	<%@ include file="header.jsp" %>
	<hr />
	<p>사이트의 본문 내용</p>
	<hr />
	<%@ include file="footer.jsp" %>
	</body>
</html>