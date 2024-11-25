<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 상세보기</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>

<div class="container">
	<div>
		<h2>회원정보 상세보기</h2>
	</div>
	
	<div>
		<table class="table table-bordered">
			<tr>
				<th>username</th>
				<td>${memberResponse.username}</td>
			</tr>
			<tr>
				<th>name</th>
				<td>${memberResponse.name}</td>
			</tr>
			<tr>
				<th>createDate</th>
				<td>${memberResponse.createDate}</td>
			</tr>
		</table>
	</div>
	
	<div>
		<a href="/member/list">목록</a>
		<a href="/member/update/${memberResponse.username}">수정</a>
		<a href="${memberResponse.username}">삭제</a>
	</div>
</div>

<script type="text/javascript">
	$("a").eq(2).click(function(event){
		event.preventDefault();
		let username = $(this).attr("href");
		
		let $input = $("<input>").attr("type", "hidden").attr("name", "username");
		$input.val(username);
		let $form = $("<form>");
		$form.appendTo("body");
		$form.attr("action", "/member/delete").attr("method", "post").append($input).submit();
	});

</script>
</body>
</html>