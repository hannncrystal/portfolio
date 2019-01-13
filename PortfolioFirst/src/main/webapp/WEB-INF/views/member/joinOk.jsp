<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Join completed</title>
</head>
<body>
	<h1> Join statement </h1>
	IDX : ${member.member_IDX}<br />
	id : ${member.member_id}<br />
	pw : ${member.member_pw}<br />
	name : ${member.member_name}<br />
	mobile : ${member.member_mobile}<br />
	email : ${member.member_email}<br />
	date : ${member.member_date}<br />
	available : ${member.member_available}<br />
	
	<a href="${cp}/"> HOME </a>
</body>
</html>
