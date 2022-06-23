<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>jsp05_JSTL</title>
</head>
<body>
	step01 : JSTL 단일 조건 <br/>
	<c:if test="${'a'=='a'}">여기가 출력된다면 이것은 참</c:if>
	step02 : JSTL 다중 조건 <br/>
	<%session.setAttribute("busan","7층");%>
	<c:choose>
		<c:when test="${sessionScope.busan  == '6층'}">여기는 공사중<br/></c:when>
		<c:when test="${sessionScope.busan  == '7층'}">열공하고 집에 갑시다<br/></c:when>
	</c:choose>
	step03 : null값 검증<br/>
	<%
		request.setAttribute("data", "hello");
	%>
	<c:if test="${not empty requestScope.data}">
		null값이 아닙니다.!!!!
	</c:if>
	<hr>
	
	step04: JSTL의 반복<br/>
	<%
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("str1");
		arr.add("str2");
		arr.add("str3");
		arr.add("str4");
		arr.add("str5");
		session.setAttribute("arr",arr);
	%>
	
	1~5출력 <br/>
	<c:forEach var="i" begin="1" end="5">
		<p> <c:out value="${i}"></c:out> </p>	
	</c:forEach>
	1~5 step2 <br/>
	<c:forEach var="i" begin="1" end="5" step="2">
		<p> <c:out value="${i}"></c:out> </p>	
	</c:forEach>
	
	
	반복에 대한 상태 파악을 위해 count, index1<br/>
	<table id="arrayList" border = "1">
		<tr><th>index</th><th>var</th><th>count</th></tr>
		<c:forEach begin ="1" end="5" var="myVar" varStatus="LoopStatus">
			<tr> 
				<td>${LoopStatus.index}</td>
				<td>${myVar}</td>
				<td>${LoopStatus.count}</td>
			</tr>
		</c:forEach>
	</table>
	
	반복에 대한 상태 파악을 위해 count, index2<br/>
	<table id="arrayList" border = "1">
		<tr><th>NO</th><th>var</th></tr>
		<c:forEach var="myVar" items="${sessionScope.arr}" varStatus="LoopStatus">
			<tr> 
				<td>${LoopStatus.index}</td>
				<td>${myVar}</td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	
	

</body>
</html>