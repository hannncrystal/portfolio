<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1" charset=UTF-8>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>	
	<div class="container">
	  <h2>Board</h2>
	  <h4>당신의 이름은 : ${sessionScope.membersession.member_name}</h4>
	  <table class="table table-striped table-bordered table-hover table-condensed">
	    <thead>
	      <tr>
	        <th>번호</th>
	        <th>제목</th>
	        <th>작성자</th>
	        <th>조회수</th>
	        <th>날짜</th>
	        <th>(memberIDX)</th>
	        <th>(boardIDX)</th>
	        <th>(group)</th>
	        <th>(depth)</th>
	        <th>(step)</th>
	      </tr>
	    </thead>
	    <tbody>
	      <tr>
	      </tr>
	    <c:forEach items="${boards}" var="boards" varStatus="status">
		    <tr>
		        <td>no</td>
		        <td>
		        	<c:forEach begin="1" end="${boards.board_depth-1}">
										-
					</c:forEach> 
			        <a href="${cp}/view?board_IDX=${boards.board_IDX}">
			        	${boards.board_title}
			        </a>
		        </td>
		        <td>${writers[status.count-1]}</td>
		        <td>${boards.board_hit}</td>
		        <td>${boards.board_date}</td>
		        <td>${boards.member_IDX}</td>
		        <td>${boards.board_IDX}</td>
		        <td>${boards.board_group}</td>
		        <td>${boards.board_depth}</td>
		        <td>${boards.board_step}</td>
	        </tr>	
		</c:forEach>
	    </tbody>
	  </table>
		<a href="${cp}/writeForm"> WRITE </a>
	</div>
</body>
<%-- <body>
	<table>
		<thead>
			<tr>
				<td>번호</td>
				<td>작성자</td>
				<td>제목</td>
				<td>조회수</td>
				<td>날짜</td>
				<td>삭제</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${boardArticleDto.boardDto}" var="dto">
				<tr>
					<td>${dto.bId}</td>
					<td>${dto.bName}</td>
					<td><c:forEach begin="1" end="${dto.bIndent}">
										-
							</c:forEach> 
							<a href="${pageContext.request.contextPath}/board/content_view.do?bId=${dto.bId}">${dto.bTitle}
								<c:if test="${dto.reCount != 0}">
									(${dto.reCount})
								</c:if>
							</a>
					</td>
					<td>${dto.bHit}</td>
					<td><fmt:formatDate value="${dto.regdate}"
							pattern="yyyy-MM-dd" /></td>
					<td><a href="${pageContext.request.contextPath}/board/delete.do?bId=${dto.bId}&where_board=0">삭제</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div >
		<a role="button" href="${pageContext.request.contextPath}/board/writ"> WRITE </a>
	</div>
</body> --%>
</html>