<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>WRITE</title>
</head>
<body>
	<form action="${cp}/write" method="post">
		TITLE : <input type="text" name="board_title" ><br />
		WRITER : ${mem.member_name}<br />
		CONTENT : <input type="text" name="board_content" ><br />
		<input type="hidden" name="member_IDX" value="${mem.member_IDX}">
		<input type="submit" value="Confirm" >
		<input type="reset" value="Reset" >
	</form>
</body>
</html>