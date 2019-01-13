<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Login completed</title>
</head>
<body>
	<h1> Login statement </h1>
	ID : ${member.member_id}<br />
	PW : ${member.member_pw}<br />	
	
	<a href="${cp}/"> HOME </a>
</body>
</html>
