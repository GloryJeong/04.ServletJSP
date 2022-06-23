<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>index.jsp</title>
</head>
<body>
	<form action="emp" method ="get">
		<input name="empno" type="text" id="empno" placeholder="사원번호 입력를 입력해주세요" />
		<button type="submit">직원 정보 보기</button>
	</form>
	<!-- <button onclick="location.href='emp?empno=7369'">직원 정보 보기</button> -->
</body>
</html>