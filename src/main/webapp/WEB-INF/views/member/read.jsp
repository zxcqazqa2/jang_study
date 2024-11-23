<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 상세보기 화면</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js" type="text/javascript"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>

<div class="container">
	<div class="title">
		<h2>회원정보 상세보기</h2>
	</div>
	
	<div class="content">
		<table class="table table-bordered">
			<tr>
				<th>username</th>
				<td>${entity.username}</td>
			</tr>
			<tr>
				<th>name</th>
				<td>${entity.name}</td>
			</tr>
			<tr>
				<th>createDate</th>
				<td>${entity.createDate}</td>
			</tr>
		</table>
		<a href="#">수정</a>
		<a href="/member/list">목록</a>
		<a href="/member/insert">회원가입</a>
	</div>
</div>

</body>
</html>