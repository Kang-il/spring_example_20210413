<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL fmt라이브러리</title>
</head>
<body>

	<h1>숫자 출력</h1>
	
	<c:set var="number" value="12345678"/>
	<%--default 3자리수마다 comma 찍힘--%>
	<fmt:formatNumber value="${number}"/>
	
	
	<h1>Type 속성</h1>
	
	<%--default type=number --%>
	숫자 : <fmt:formatNumber value="${number}" type="number" /><br>
	
	<%--default groupingUsed=false --%>
	숫자 3자리마다 쉼표 제거 <fmt:formatNumber value="${number}" type="number" groupingUsed="false" /><br>
	
	<%-- percent 100% => 1을 100%로 인지  --%>
	100% : <fmt:formatNumber value="1" type="percent"/><br>
	40% : <fmt:formatNumber value="0.4" type="percent"/><br>
	
	통화 (원) : <fmt:formatNumber value="${number}" type="currency"/><br>
	통화 (달러) : <fmt:formatNumber value="${number}" type="currency" currencySymbol="$"/><br>
	
	
	
	<h1>var 로 변수에 저장</h1>
	
	<fmt:formatNumber value="${number}" type="currency" currencySymbol="$" var="dollar"/>
	달러 EL로 출력 : ${dollar}
	
	<h1>pattern</h1>
	
	3.14 : <fmt:formatNumber value="3.14" /><br>
	
	<%--남은 자릿수 0으로 출력 --%>
	3.14(0.0000) : <fmt:formatNumber value="3.14" pattern="0.0000"/><br>
	
	<%--남은 자릿수를 #개수 까지만큼만 출력 --%>
	3.14(#.####) : <fmt:formatNumber value="3.14" pattern="#.####"/><br>
	3.141592(#.####) : <fmt:formatNumber value="3.141592" pattern="#.####"/>
	
	<hr>
	
	<h1>Date객체를 String 형태로 출력 ==> fmt:formatDate</h1>
	
	<fmt:formatDate value="${today}" var="pattern1" pattern="yyyy년 MM월 dd일 HH시 mm분 ss초"/>
	pattern1 :: ${pattern1}<br>
	
	<fmt:formatDate value="${today}" var="pattern2" pattern="yyyy/MM/dd HH:mm:ss"/>
	pattern2 :: ${pattern2}<br>
	
	<h1>String 을 Date객체로 변환 ==> fmt:parseDate</h1>
	<fmt:parseDate value="${pattern2}" pattern="yyyy/MM/dd HH:mm:ss" var="date2"/>
	Date객체 :: ${date2}
</body>
</html>