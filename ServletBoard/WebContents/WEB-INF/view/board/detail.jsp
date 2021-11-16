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
		<table class="table">
			<tr>
				<td>제목</td>
				<td><%=boardDetail.getBoardTitle() %>
			</tr>
			<tr>
				<td>날짜</td>
				<td><%=boardDetail.getBoardDate()%>
			</tr>
			<tr>
				<td>작성자</td>
				<td><%=boardDetail.getBoardWriter() %>
			</tr>
			<tr style="height: 500px;">
				<td>내용</td>
				<td><%=boardDetail.getBoardContent() %>
			</tr>
		</table>
		<button type="button" class="btn" onclick='location.href="/board/detail?index="+<%=boardDetail.getBoardIndex()%>+"&type=edit"'>수정</button>
		<button type="button" class="btn" onclick='location.href="/board/delete?index="+<%=boardDetail.getBoardIndex()%>'>삭제</button>
	</div>
</body>
</html>