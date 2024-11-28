console.log("boardService.js파일 불러옴~~!");

$(function() {
	
	// 글수정 화면 취소버튼 이벤트
	$("#board_update_btn_back").click(function(){
		let bId = $(this).parent().find("input[type='hidden']").val();
		location.href=`/board/read/${bId}`;
		
	});

	// 글수정 화면 글 삭제 이벤트
	$("#board_update_btn_delete").click(function() {

		let isDelete = confirm("정말 삭제 하시겠습니까?");

		if (isDelete) {
			let $form = $("#board_update_updateForm");
			$form.attr("action", "/board/delete").submit();
		}
	});

	// 글수정 화면 수정완료 버튼 이벤트
	$("#board_update_btn_update").click(function() {
		let $form = $("#board_update_updateForm");
		let writer = $("table tr").eq(1).find("td").eq(0).text();
		let $input = $("<input>");
		$input.attr("name", "writer").attr("type", "hidden");
		$input.val(writer);
		$form.append($input);
		$form.submit();
	});

	// 글상세 화면 글삭제 이벤트
	$("a").eq(2).click(function(event) {
		event.preventDefault();
		let isDelete = confirm("정말 삭제 하시겠습니까?");
		let id = $(this).attr("href");
		if (isDelete) {
			let $input = $("<input>")
			$input.attr("name", "id").attr("type", "hidden").val(id);
			let $form = $("<form>");
			$form.attr("action", "/board/delete").attr("method", "post").append($input).appendTo("body").submit();
		}
	});

});