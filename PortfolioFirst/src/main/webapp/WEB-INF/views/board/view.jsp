<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>TITLE</title>
</head>
<body>
	<div>
		TITLE : ${bo.board_title}
		<br>
		WRITER : ${writer}
		<br>
		CONTENT : ${bo.board_content}
		<br>
		HIT : ${bo.board_hit}
		<br>
		DATE : ${bo.board_date}
	</div>
	<form action="${cp}/articleModifyForm" method="post">
		<input type="hidden" name="board_IDX" value="${bo.board_IDX}">
		<input type="hidden" name="member_IDX" value="${bo.member_IDX}">
		<%-- 
		<button onclick="location.href='${cp}/articleModifyForm'" value="Modify">Modify</button>
		<button onclick="location.href='${cp}/articleDelete'" value="Delete">Delete</button>
		<button onclick="location.href='${cp}/replyForm'" value="Reply">Reply</button>
		<button onclick="location.href='${cp}/list'" value="List">List</button>
		
 		<input type="submit" value="Modify" >
 		<input type="button" value="Delete" >
 		<input type="button" value="Reply" >
		<input type="button" value="List" >
		 --%>
		 <div>
			<input type="submit" value="Modify">
			
			<a href="${pageContext.request.contextPath}/list">List</a>
			<a href="${pageContext.request.contextPath}/articleDelete?board_IDX=${bo.board_IDX}">Delete</a>
			<a href="${pageContext.request.contextPath}/replyForm?board_IDX=${bo.board_IDX}">Reply</a>
			
		</div>

 	</form>
</body>
</html>