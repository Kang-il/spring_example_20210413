<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core 라이브러리</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>

	<h2>변수 정의하기 (c:set)</h2>
	<c:set var="number1" value="100"/>
	<c:set var="number2">200</c:set>
	
	<h4>number1 : ${number1}</h4>
	<h4>number2 : ${number2}</h4>
	
	<h4>number1+number2: ${number1+number2}</h4>
	
	<%-- c:out : value 속성에 있는 값이 출력된다. --%>
	<h2>변수 출력하기 (c:out) number : <c:out value="10"/></h2>
	<h4>number1 : <c:out value="${number1}"/></h4>
	
	<%-- 태그 문구가 그대로 출력된다. --%>
	<c:out value="<script> alert('출력') </script>"/>
	
	<c:out value="<script>alert('그대로 출력')</script>" escapeXml="true"/>
	
	<%-- 스크립트가 수행된다 --%>
	<%-- <c:out value="<script>alert('뜬다')</script>" escapeXml="false"/> --%>
	
	<h2>조건문</h2>
	<c:if test="true">
		<h4>조건이 참이다.</h4>
	</c:if>
	
	<c:if test="${number1>50}">
		<h4>number1은 50보다 크다.</h4>
	</c:if>
	
	<%--JSTL 문법에서 같다 비교시 == 을 잘 사용하지 않는다 --%>
	<c:if test="${number1 eq 100}">
		<h4>number1은 100이다.</h4>
	</c:if>
	
	<%--같지 않다. --%>
	<c:if test="${number2 ne 100}">
		<h4>number2는 200이 아니다.</h4>
	</c:if>
	
	<%--비어있다--%>
	<c:if test="${empty number2}">
		<h4>number2는 비어있다.</h4>
	</c:if>
	
	<%--비어있지 않다--%>
	<c:if test="${not empty number2}">
		<h4>number2는 비어있지 않다.</h4>
	</c:if>
	
</body>
</html>