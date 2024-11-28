<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정화면</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js" type="text/javascript"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

<link rel="stylesheet" href="/css/style.css">
</head>
<body>
<%@ include file="../part_header.jsp" %>

<div class="container">
	<div>
		<h2>글 수정</h2>
	</div>
	
	<div>
		<form id="board_update_updateForm" action="/board/update" method="post">
			<table class="table table-bordered">
				<tr>
					<th>게시글번호</th>
					<td>${boardResponse.id}
						<input type="hidden" name="id" value="${boardResponse.id}">
					</td>
					<th>제목</th>
					<td>
						<input name="title" value="${boardResponse.title}">
					</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${boardResponse.writer}</td>
					<th>작성일</th>
					<td>${boardResponse.writeDate}</td>
				</tr>
				<tr>
					<td colspan="4">
						<textarea rows="7" name="content">${boardResponse.content}</textarea>
					</td>
				</tr>
			</table>
		</form>
		<button id="board_update_btn_update" type="button">수정완료</button>
		<button id="board_update_btn_back" type="button">취소</button>
		<button id="board_update_btn_delete" type="button">삭제</button>
		<a href="/board/list">목록</a>
	</div>
</div>

<script type="text/javascript" src="/js/boardService.js"></script>
</body>
</html>