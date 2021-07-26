<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core 라이브러리</title>
</head>
<body>

	<h1>1. 조건문 (c:choose,c:when,c:otherwise)</h1>
	
	<%-- 몸무게 70이하면 치킨, 80이하면 샐러드, 그 이상이면 굶자  --%>
	<c:set var="weight" value="75"/>
	
	<c:choose>
	
		<c:when test="${weight<=70}">
			<p>치킨</p>
		</c:when>
		
		<c:when test="${weight<=80}">
			<p>샐러드</p>
		</c:when>
		
		<c:otherwise>
			<p>굶자</p>
		</c:otherwise>
		
	</c:choose>
	
	<h1>2. 반복문 (c:forEach)</h1>
	<%-- money in pocket --%>
	<%-- for(int i=0 ; i<=5 ; i++) --%>
	
	<%-- 0부터 5까지 6번 --%>
	<c:forEach var="i" begin="0" end="5" step="1">
		${i}
	</c:forEach>
	
	<br>
	
	<c:forEach var="j" begin="16" end="20" step="1" varStatus="status"> <%-- varStatus == 변수의 상태 --%>
		j : ${j} <br> 
		current : ${status.current}  <br>
		first(반복문이 첫 회 돌았을 때 찍힌다.) : ${status.first} <br>
		last(반복문이 마지막 회 돌았을 때 찍힌다.) : ${status.last} <br>
		count : ${status.count}<br>
		index: ${status.index}<br>
		<br>
	</c:forEach>
	
	<br>
	
	<%-- 서버에서 가져온 List --%>
	<c:forEach var="fruit" items="${fruits}" varStatus="status">
		${fruit} :::: ${status.count} ::::: ${status.index}
	</c:forEach>
	
	<%--서버에서 가져온 ListMap --%>
	<c:forEach var="users" items="${users}" varStatus="status">
		<h3>${status.count}번째 사람</h3>
		이름 : ${users.name}<br>
		나이 : ${users.age}<br>
		취미 : ${users.hobby}<br>
	</c:forEach>
	
	<%--테이블 구성 --%>
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>나이</th>
				<th>취미</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${users}" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td>${user.name}</td>
					<td>${user.age}</td>
					<td>${user.hobby}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>