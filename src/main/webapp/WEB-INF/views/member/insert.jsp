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


<div class="container">
	
	<div class="title">
		<h2>회원가입</h2>
	</div>
	
	<div class="content">
		
		<form id="member_insert_insertForm" action="/member/insert" method="post">
			<table class="table table-bordered">
				<tr>
					<th>username</th>
					<td>
						<input name="username"><button type="button" id="member_insert_btn_checkId">중복검사</button>
					</td>
				</tr>
				<tr>
					<th>password</th>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<th>name</th>
					<td><input name="name"></td>
				</tr>
			</table>
			<button type="button" id="member_insert_btn_submit">회원가입</button>
		</form>
		
	</div>
	
	
</div>

<script type="text/javascript" src="/js/test1.js"></script>
<script type="text/javascript">
	
	let isOk = false;
	
	// 회원가입 버튼 클릭 이벤트
	$("#member_insert_btn_submit").click(function(){
		if(!isOk){
			alert("중복검사 하세요");
			return;
		}
		$("#member_insert_insertForm").submit();
	});
	
	// username 입력한 값 변경시 이벤트 --> input안되서 -> on으로 변경하니깐 됨.
	$("body").on("input", "input[name='username']", function(){
		isOk = false;
	});
	
	// 중복검사 버튼 클릭 이벤트
	$("#member_insert_btn_checkId").click(function(){
		let username = $(this).prev().val();
		
		$.ajax({
			url : "/member/checkId",
			type : "get",
			data : {
				username : username
			},
			dataType : "text",
			success : function(result){
				if(result =='ok') {
					alert("사용가능한 아이디");
					isOk = true;
					return;
				}
				alert("이미 사용중인 아이디");
			}
		});
		
	});

</script>
</body>
</html>