console.log("memberService.js파일 불러오기 성공~!");

$(function() {

	// 회원정보 수정페이지 수정완료 버튼 이벤트 
	$(".member_update_btns").find("a").eq(1).click(function(event) {
		event.preventDefault();
		let username = $(this).attr("href");
		let $input = $("<input>").attr("type", "hidden").attr("name", "username").val(username);
		let $form = $(this).parent().prev().find("form");
		$form.append($input).submit();
	});

	// 회원정보 수정페이지 삭제 버튼 이벤트 
	$(".member_update_btns").find("a").eq(2).click(function(event) {
		event.preventDefault();
		let username = $(this).attr("href");

		let $input = $("<input>").attr("type", "hidden").attr("name", "username");
		$input.val(username);
		let $form = $("<form>");
		$form.appendTo("body");
		$form.attr("action", "/member/delete").attr("method", "post").append($input).submit();
	});


	// 회원상세 페이지 삭제 버튼 이벤트
	$(".member_read_btns").find("a").eq(2).click(function(event) {
		event.preventDefault();
		let username = $(this).attr("href");

		let $input = $("<input>").attr("type", "hidden").attr("name", "username");
		$input.val(username);
		let $form = $("<form>");
		$form.appendTo("body");
		$form.attr("action", "/member/delete").attr("method", "post").append($input).submit();
	});




	// 변수명 짓기 어려워요...
	let isPassCheckId = false;
	let isPassConfirmPass = false;

	// 회원가입 버튼 클릭 이벤트
	$("#member_insert_btn_submit").click(function() {
		if (!isPassCheckId) {
			alert("중복검사 하세요");
			return;
		}
		if (!isPassConfirmPass) {
			alert("비밀번호가 일치하지 않습니다.");
			return;
		}

		$("#member_insert_insertForm").submit();
	});

	// password2 입력한 값 변경시 이벤트
	$("#member_insert_insertForm").on("input", "input[name='password2']", function() {
		$("#member_insert_insertForm").find("span").removeAttr("style").text('');
		let pass1 = $("input[name='password']").val();
		let pass2 = $("input[name='password2']").val();

		if (!pass1 || !pass2) {
			isPassConfirmPass = false;
			return;
		}

		if (pass1 == pass2) {
			isPassConfirmPass = true;
			$("#member_insert_insertForm").find("span").attr("style", "color: blue").text("비밀번호 일치");
			return;
		}
		isPassConfirmPass = false;
		$("#member_insert_insertForm").find("span").attr("style", "color: red").text("비밀번호 불일치");
	});

	// password 입력한 값 변경시 이벤트
	$("#member_insert_insertForm").on("input", "input[name='password']", function() {
		$("#member_insert_insertForm").find("span").removeAttr("style").text('');
		let pass1 = $("input[name='password']").val();
		let pass2 = $("input[name='password2']").val();

		if (!pass1 || !pass2) {
			isPassConfirmPass = false;
			return;
		}

		if (pass1 == pass2) {
			isPassConfirmPass = true;
			$("#member_insert_insertForm").find("span").attr("style", "color: blue").text("비밀번호 일치");
			return;
		}
		isPassConfirmPass = false;
		$("#member_insert_insertForm").find("span").attr("style", "color: red").text("비밀번호 불일치");
	});

	// username 입력한 값 변경시 이벤트 --> input안되서 -> on으로 변경하니깐 됨.
	$("#member_insert_insertForm").on("input", "input[name='username']", function() {
		isPassCheckId = false;
	});

	// 중복검사 버튼 클릭 이벤트
	$("#member_insert_btn_checkId").click(function() {
		let username = $(this).parent().prev().find("input").val();

		$.ajax({
			url: "/member/checkId",
			type: "get",
			data: {
				username: username
			},
			dataType: "text",
			success: function(result) {
				if (result == 'ok') {
					alert("사용가능한 아이디");
					isPassCheckId = true;
					return;
				}
				alert("이미 사용중인 아이디");
			}
		});

	});


});