<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Insert title here</title>
		<link href="../image/icon.png" rel="icon" type="image/x-icon" />
		<style>table {border-collapse : collapse; width 700px }
		th,td { border: solid black 1px; text-align:center;}
		
		
		</style>
	</head>
	<body>
	<h3>서클릿으로부터 전달받은 속성 출력</h3>
	<table>
		<tr>
			<th>회원이름</th>
			<th>아이디</th>
			<th>회원번호</th>
			<th>회원주소</th>
			<th>회원우편번호</th>
		</tr>
		<tr>
			<td>${user.uname}</td>
			<td>${user.uid}</td>
			<td>${user.unum}</td>
			<td>${user.address.city}</td>
			<td>${user.address.zipcode}</td>
		</tr>
	</table>

	</body>
</html>