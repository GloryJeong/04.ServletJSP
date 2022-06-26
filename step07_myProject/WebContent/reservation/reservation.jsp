<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>reservation</title>
</head>
<body>
	<div style="background-color : lightblue;
	 			text-align : center"> 
	<h1> reservation page</h1>
	</div>
	<form align = "right" action="room?command=select" method="get">
		<input name="command" value="select" type="hidden"/>
		<input name="selectId" placeholder="예약 번호로  검색"/> 
		<button type="submit">검 색</button>
	</form>
	<br/>
	<table align="center" border="0" cellpadding="5" cellspacing="2" width="100%" bordercolordark="white" bordercolorlight="black">
	<tr>
        <td bgcolor="#336699">
            <p align="center">
            <font color="white"><b><span style="font-size:9pt;">예약 ID</span></b></font></p>
        </td>
        <td bgcolor="#336699">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">고객 ID</span></b></font></p>
        </td>
        <td bgcolor="#336699">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">객실 ID</span></b></font></p>
        </td>
        <td bgcolor="#336699">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">시작 일자</span></b></font></p>
        </td>
        <td bgcolor="#336699">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">마지막 일자</span></b></font></p>
        </td>
    </tr>
    
 	<c:if test="${empty reservationList || fn:length(reservationList) == 0}">
		<tr>
	        <td colspan="5">
	            <p align="center"><b><span style="font-size:9pt;">등록된 객실 정보가 없습니다.</span></b></p>
	        </td>
	    </tr>
	</c:if>

	<c:forEach items="${requestScope.reservationList}" var="data">
		    <tr>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">${data.reservationId}</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
						 ${data.maxCapacity}
					</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		             ${data.price}</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		             ${data.region}</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center">
		            <button onclick="location.href='room?command=delete&roomId=${data.roomId}'">삭 제</button>
		            <button onclick="location.href='room/roomUpdate.jsp?roomId=${data.roomId}'">수 정</button>
		            </p>
		            
		        </td>
		    </tr>
	</c:forEach>
	</table>
	<div align=right>
<span style="font-size:9pt;">&lt;<a href="/step07_myProject/index.jsp">메인 메뉴</a>&gt;</span>
<span style="font-size:9pt;">&lt;<a href="/step07_myProject/room/roomAdd.html">객실 추가</a>&gt;</span>


<c:if test="${param.command == 'select' }">
	<span style="font-size:9pt;">&lt;<a href="room">전체 리스트 보기</a>&gt;</span>
</c:if>
</div>

	

</body>
</html>