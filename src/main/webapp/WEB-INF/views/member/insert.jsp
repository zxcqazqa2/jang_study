<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 화면</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js" type="text/javascript"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

<link rel="stylesheet" href="/css/style.css">
</head>
<body>
<%@ include file="../part_header.jsp" %>

<div class="container">
	
	<div class="title">
		<h2>회원가입</h2>
	</div>
	
	<div class="content">
		
		<form:form id="member_insert_insertForm" modelAttribute="memberForm" action="/member/insert" method="post">
			<%-- <form:errors path="*" cssClass="errorblock" element="div"></form:errors> --%>
			<table class="table table-bordered">
				<tr>
					<th><form:label path="username">username</form:label></th>
					<td>
						<form:input path="username"/>
						<form:errors path="username"></form:errors>
					</td>
					<td><button type="button" id="member_insert_btn_checkId">중복검사</button></td>
				</tr>
				<tr>
					<th><form:label path="password">password</form:label></th>
					<td colspan="2">
						<form:input type="password" path="password"/><span style=""></span>
						<form:errors path="password"></form:errors>
					</td>
				</tr>
				<tr>
					<th><form:label path="password2">password확인</form:label></th>
					<td colspan="2">
						<form:input type="password" path="password2"/><span></span>
						<form:errors path="password2"></form:errors>
					</td>
				</tr>
				<tr>
					<th><form:label path="name">name</form:label></th>
					<td>
						<form:input path="name"/>
						<form:errors path="name"></form:errors>
					</td>
				</tr>
			</table>
			<button type="button" id="member_insert_btn_submit">회원가입</button>
		</form:form>
		
	</div>
	
	
</div>

<script type="text/javascript" src="/js/memberService.js"></script>
</body>
</html>