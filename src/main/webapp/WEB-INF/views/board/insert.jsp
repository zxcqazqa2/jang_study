<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글작성화면</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js" type="text/javascript"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>

<div>
	<div>
		<h2>글작성</h2>
	</div>
	
	<div>
		<form action="/board/insert" method="post">
			<table class="table table-bordered">
				<tr>
					<th>카테고리</th>
					<td>
						<select name="cName">
							<option value="notice">공지사항</option>
							<option value="free">자유게시판</option>
						</select>
					</td>
					<th>제목</th>
					<td><input name="title"></td>
					<th>작성자</th>
					<td><input name="writer"></td>
				</tr>
				<tr>
					<td colspan="4">
						<textarea rows="5" name="content"></textarea>
					</td>
				</tr>
			</table>
			<button>등록</button>
		</form>
	</div>
</div>

</body>
</html>