<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>WRITE</title>
</head>
<body>
	<form action="${cp}/reply" method="post">
		TITLE : <input type="text" name="board_title" value="RE:${bo.board_title}">
		WRITER : ${mem.member_name}<br />
		CONTENT : <input type="text" name="board_content" value="원글 [IDX : ${bo.board_IDX} + 작성자 : ${bo.member_IDX} + 본문 : ${bo.board_content}] + 답글 : ">
		<input type="hidden" name="board_IDX" value="${bo.board_IDX}">
		<input type="hidden" name="board_group" value="${bo.board_group}">
		<input type="hidden" name="board_depth" value="${bo.board_depth}">
		<input type="hidden" name="board_step" value="${bo.board_step}">
		<input type="hidden" name="member_IDX" value="${mem.member_IDX}">
		<input type="submit" value="Confirm" >
		<input type="reset" value="Reset" >
	</form>
</body>
</html>
