<%@ page import="com.board.dto.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	BoardDTO boardDetail = (BoardDTO) request.getAttribute("boardDetail");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servlet Board</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<form accept-charset="UTF-8" action='/board/update?index=<%=boardDetail.getBoardIndex()%>' method="post">
			<input type="hidden" value="<%= boardDetail.getBoardIndex()%>" name="boardIndex" />
			<div class="form-group">
				<label for="title">제목</label> 
				<input type="text"
					class="form-control" id="title" name="boardTitle"
					value="<%=boardDetail.getBoardTitle() %>">
			</div>
			<div class="form-group">
				<label for="content">내용</label>
				<textarea class="form-control" id="content" name="boardContent" rows="20"><%=boardDetail.getBoardContent() %></textarea>
			</div>
			<button type="submit" class="btn btn-dark">저장</button>
		</form>
	</div>
</body>
</html>