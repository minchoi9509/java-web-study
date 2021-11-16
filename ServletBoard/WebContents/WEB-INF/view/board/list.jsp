<%@ page import = "java.util.*" %>
<%@ page import = "com.board.dto.BoardDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<BoardDTO> boardList = (ArrayList<BoardDTO>) request.getAttribute("boardList");
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
			<thead class="thead-dark">
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<% for (int i = 0; i < boardList.size(); i++) { 
					BoardDTO board = boardList.get(i);
				%>
				<tr onclick='location.href="/board/detail?index="+<%=board.getBoardIndex()%>'>
					<td><%= i %></td>
					<td><%= board.getBoardTitle() %></td>
					<td><%= board.getBoardWriter() %></td>
					<td><%= board.getBoardDate() %></td>
				</tr>
				<% } %>
			</tbody>
		</table>
		
		<button type="button" class="btn btn-dark" onclick='location.href="/board/insertForm"'>글쓰기</button>
	</div>
</body>
</html>