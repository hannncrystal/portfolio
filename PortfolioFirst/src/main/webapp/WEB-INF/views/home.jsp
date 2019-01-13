<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>
		Hello world!  
	</h1>
	
	<P>  The time on the server is ${serverTime}. </P>
	
	<button onclick="location.href='/hannncrystal/resources/login.html'">LOGIN</button>
	<button onclick="location.href='/hannncrystal/resources/join.html'">JOIN</button>

	
	<c:if test="${empty member}">
		<a href="/hannncrystal/resources/join.html">JOIN</a> &nbsp;&nbsp; 
		<a href="/hannncrystal/resources/login.html">LOGIN</a> &nbsp;&nbsp; 
		<a href="${cp}/modifyForm">MODIFY</a> &nbsp;&nbsp; 
		<a href="${cp}/logout">LOGOUT</a> &nbsp;&nbsp;
		<a href="${cp}/removeForm">REMOVE</a> &nbsp;&nbsp; 
	</c:if>
	
	<!-- 실행이 안됨 -->
	<c:if test="${!empty member}">
		<a href="${cp}/modifyForm">MODIFY</a> &nbsp;&nbsp; 
		<a href="${cp}/logout">LOGOUT</a> &nbsp;&nbsp;
		<a href="${cp}/removeForm">REMOVE</a> &nbsp;&nbsp; 
	</c:if>
	
</body>
</html>
