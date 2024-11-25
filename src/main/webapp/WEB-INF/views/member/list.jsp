<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록 화면</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>

<div class="container">
	<div>
		<h2>회원목록</h2>
	</div>
	
	<div>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>username</th>
					<th>name</th>
					<th>createDate</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${memberList}" var="dto">
					<tr>
						<td><a href="/member/read/${dto.username}">${dto.username}</a></td>
						<td>${dto.name}</td>
						<td>${dto.createDate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
</div>

</body>
</html>