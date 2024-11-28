<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세 화면</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js" type="text/javascript"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>

<div>
	<div>
		<h2>글 상세보기</h2>
	</div>
	
	<div>
		<table class="table table-bordered">
			<tr>
				<th>게시글번호</th>
				<td>${boardResponse.id}</td>
				<th>제목</th>
				<td>${boardResponse.title}</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${boardResponse.writer}</td>
				<th>작성일</th>
				<td>${boardResponse.writeDate}</td>
			</tr>
			<tr>
				<td colspan="4">
					<pre>${boardResponse.content}</pre>
				</td>
			</tr>
		</table>
		<a href="/board/list">목록</a>
		<a href="/board/update/${boardResponse.id}">수정</a>
		<a href="${boardResponse.id}">삭제</a>
	</div>
	<hr>
	
	<h2>댓글</h2>
	<div class="board_read_replyForm">
		<div>
			작성자 : <input name="writer">
		</div>
		<div>
			<textarea rows="3" name="content"></textarea>
			<button id="reply_btn_insert">등록</button>
		</div>
	</div>
	<hr>
	<div class="replyList">
	
	</div>
	
	
</div>

<script type="text/javascript" src="/js/boardService.js"></script>
<script type="text/javascript" src="/js/replyService.js"></script>
</body>
</html>