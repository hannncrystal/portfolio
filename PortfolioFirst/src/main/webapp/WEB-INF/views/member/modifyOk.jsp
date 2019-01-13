<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Modify completed</title>
</head>
<body>
	<h1> Modify statement </h1>
	IDX : ${modified.member_IDX}<br />
	id : ${modified.member_id}<br />
	pw : ${modified.member_pw}<br />
	name : ${modified.member_name}<br />
	mobile : ${modified.member_mobile}<br />
	email : ${modified.member_email}<br />
	date : ${modified.member_date}<br />
	available : ${modified.member_available}<br />
		
	<a href="${cp}/"> HOME </a>
</body>
</html>
