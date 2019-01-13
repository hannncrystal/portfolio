<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>MEMBER REMOVE</h1>
	
	<form:form action="${cp}/remove" method="post" commandName="member">
		<input type="hidden" name="member_id" value="${member.member_id}">
		<table>
			<tr>
				<td>ID</td>
				<td>${member.member_id}</td>
			</tr>
			<tr>
				<td>PW</td>
				<td><form:password path="member_pw" /></td>
			</tr>
			<tr>
				<td>NAME</td>
				<td>${member.member_name}</td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="submit" value="Remove" ></td>
			</tr>
		</table>
	</form:form>
	
</body>
</html>