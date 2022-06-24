<%@page import="reservation.model.CustomerDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">

<title>customer</title>
</head>
<body>
	<div style="background-color : lightblue;
	 			text-align : center"> 
	<h1> customer page</h1>
	</div>
	<br/>
	<%-- <c:forEach var="myVar" items="${requestScope.customerList}" varStatus="LoopStatus">
				<div>${myVar}</div>
	</c:forEach> --%>
	<table align="center" border="0" cellpadding="5" cellspacing="2" width="100%" bordercolordark="white" bordercolorlight="black">
	<tr>
        <td bgcolor="#336699">
            <p align="center">
            <font color="white"><b><span style="font-size:9pt;">ID</span></b></font></p>
        </td>
        <td bgcolor="#336699">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">인 원 수</span></b></font></p>
        </td>
        <td bgcolor="#336699">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">이 름</span></b></font></p>
        </td>
        <td bgcolor="#336699">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">전 화 번 호 </span></b></font></p>
        </td>
        <td bgcolor="#336699">
            <p align="center"><font color="white"><b><span style="font-size:9pt;"> 옵 션 </span></b></font></p>
        </td>
    </tr>
    
 	<c:if test="${empty customerList || fn:length(customerList) == 0}">
		<tr>
	        <td colspan="5">
	            <p align="center"><b><span style="font-size:9pt;">등록된 방명록이 없습니다.</span></b></p>
	        </td>
	    </tr>
	</c:if>

	<%-- ArrayList에  GuestBookBean 객체를 하나하나 data라는 반복 대입해서 사용 --%>
	<c:forEach items="${requestScope.customerList}" var="data">
		    <tr>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">${data.customerId}</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
						 ${data.headCount}
					</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		             ${data.customerName}</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		             ${data.phoneNumber}</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><button onclick="location.href='customer?command=delete&customerId=${data.customerId}'">삭제하기</button></p>
		        </td>
		    </tr>
	</c:forEach>
	</table>
	<div align=right>
<span style="font-size:9pt;">&lt;<a href="customerAdd.html">고객 추가</a>&gt;</span></div>
	

</body>
</html>