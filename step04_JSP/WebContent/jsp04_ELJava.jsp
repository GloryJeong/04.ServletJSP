<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.domain.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>jsp04_ELJava.jsp</title>
</head>
<body>
	<h3>String 데이터 출력</h3>
	<%
		session.setAttribute("sessionData","hi");
		request.setAttribute("requestData", "hello");
	%>
	${sessionScope.sessionData } <br/>
	${requestScope.requestData }
	
	<h3>DTO 데이터 출력</h3>
	<%
		Student student1 = new Student("김윤호",26);
		Student student2 = new Student("김도헌",26);
		session.setAttribute("yh",student1);
		session.setAttribute("dh",student2);
	%>
	${sessionScope.yh }
	
	<h3>ArrayList 데이터 출력</h3>
	<%
		ArrayList<Student> arr = new ArrayList<Student>();
		arr.add(student1);
		arr.add(student2);
		session.setAttribute("arr", arr);
	%>
	${sessionScope.arr[1].getAge()}<br/>
	${sessionScope.arr.get(1).getAge()}

	
	
</body>
</html>