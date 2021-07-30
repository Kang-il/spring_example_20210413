<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL fn 라이브러리</title>
</head>
<body>

	
	<h2>1.문자열 길이 구하기</h2>
	<c:set var="str1" value="No pain. No gain."/>
	<h1>str1::: ${str1}</h1>
	${fn:length(str1)}
	<h2>2.특정 문자열이 존재하는가?</h2>
	<%-- fn:contains는 대소문자를 구별하여 특정 문자열 포함여부를 확인한다. --%>
	<h4>-1.No가 존재하는가</h4>
	${fn:contains(str1,'No')}
	<h4>-2.no가 존재하는가</h4>
	${fn:contains(str1,'no')}
	<h4>-3.(no || No || nO || NO) 가 문자열에 존재하는가</h4>
	<%--대소문자를 무시하고 특정 문자열 포함이 되어있는지 확인--%>
	<c:if test="${fn:containsIgnoreCase(str1,'no')}">
		<p>문장에 (no || No || nO || NO) 라는 문자열이 존재합니다. (대소문자 구별안함)</p>
	</c:if>
	
	<h2>3.특정 문자열로 시작하는 지 확인</h2>
	<h4>-1.No 로 시작하는가?</h4>
	${fn:startsWith(str1,'No')}
	<h4>-2.no 로 시작하는가?</h4>
	${fn:startsWith(str1,'no')}
	
	<h2>4.특정 문자열로 끝나는 지 확인</h2>
	<h4>-1.n 으로 끝나는가?</h4>
	${fn:endsWith(str1,'n')}
	<h4>-2. 'gain.' 으로 끝나는가?</h4>
	${fn:endsWith(str1,'gain.')}
	
	<h2>5. 문자열 치환</h2>
	<c:set var="str2" value="I love chicken"/>
	<h1> str2::: ${str2}</h1>
	${fn:replace(str2,'chicken','bread') }
	
	<h2>6.str1 구분자로 잘라서 배열로 만들기</h2>
	${fn:split(str1,'.')[0]}<br>
	${fn:split(str1,'.')[1]}
	
	
	<h2>7.시작 인덱스부터 종료 인덱스까지 자르기</h2>
	${str2}<br>
	<%--str2에서 love추출 I love chicken--%>
	${fn:substring(str2 , 2 , 6 )}
	
	<h2>8.모두 소문자로 변경</h2>
	${fn:toLowerCase(str2)}
	<h2>9.모두 대문자로 변경</h2>
	${fn:toUpperCase(str2)}
	<h2>10.앞뒤 공백 제거</h2>
	<c:set var="str3" value="             Hello               "/>
	<pre>${str3}</pre><br>
	<pre>${fn:trim(str3)}</pre>
	
</body>
</html>