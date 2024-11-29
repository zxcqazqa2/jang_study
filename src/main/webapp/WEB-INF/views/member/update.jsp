<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정화면</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

<link rel="stylesheet" href="/css/style.css">
</head>
<body>
<%@ include file="../part_header.jsp" %>

<div class="container">
	<div>
		<h2>회원정보 수정</h2>
	</div>
	
	<div>
		<form action="/member/update" method="post">
			<table class="table table-bordered">
				<tr>
					<th>username</th>
					<td>${memberResponse.username}</td>
				</tr>
				<tr>
					<th>name</th>
					<td><input name="name" value="${memberResponse.name}"></td>
				</tr>
				<tr>
					<th>createDate</th>
					<td>${memberResponse.createDate}</td>
				</tr>
			</table>
		</form>
	</div>
	
	<div class="member_update_btns">
		<a href="/member/list">목록</a>
		<a href="${memberResponse.username}">수정완료</a>
		<a href="${memberResponse.username}">삭제</a>
	</div>
</div>

<script type="text/javascript" src="/js/memberService.js"></script>
</body>
</html>