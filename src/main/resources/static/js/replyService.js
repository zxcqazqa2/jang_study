console.log("replyService.js파일 불러옴.");

function replyListRender(obj){
	let tag = ``;
	
	for(el of obj){
		tag+=`
			<div>
				작성자 : ${el.writer} | 작성일 : ${el.writeDate}<br>
				<div class='replyContent'>${el.content}</div>
				
				<div>
					<button class="reply_btn_toUpdateForm">수정</button>
					<button data-rId="${el.id}" class="reply_btn_delete">삭제</button>
				</div>
				
				<div style="display: none;">
					<button data-rId="${el.id}" class="reply_btn_update">수정완료</button>
					<button class="reply_btn_back">취소</button>
				</div>
				
				<input type='hidden' value='${el.content}'>
			</div>
			<hr>
		`
	}
	
	$(".replyList").html(tag);
	
	// 댓글 삭제 버튼 클릭 이벤트
	$(".reply_btn_delete").each(function(){
		$(this).click(function(){
			let id = $(this).attr("data-rId");
			let isDelete = confirm("정말 삭제 하시겠습니까?");
			
			if(isDelete) {
				
				$.ajax({
					url : "/replies/",
					type: "delete",
					data: JSON.stringify({
						id: id
					}),
					headers: {
						"Content-Type": "application/json",
						"X-HTTP-Method-Override": "DELETE"
					},
					dataType: "text",
					success: function(result) {
						getReplyList();
					}
				});
				
			}
			
		});
	});
	
	// 댓글 수정완료 버튼 이벤트
	$(".reply_btn_update").each(function(){
		$(this).click(function(){
			let id = $(this).attr("data-rId");
			let content = $(this).closest("div").parent().find("textarea").val();
			
			$.ajax({
				url : "/replies/",
				type : "put",
				data : JSON.stringify({
					id : id,
					content : content
				}),
				headers: {
					"Content-Type": "application/json",
					"X-HTTP-Method-Override": "PUT"
				},
				dataType: "text",
				success: function(result) {
					getReplyList();
				}
			});
			
		});
	});
	
	// 댓글 수정취소 버튼 클릭 이벤트
	$(".reply_btn_back").each(function(){
		$(this).click(function(){
			let orgContent = $(this).closest("div").parent().find("input").val();
			$(this).closest("div").parent().find(".replyContent").text(orgContent);
			
			$(this).closest("div").hide();
			$(this).closest("div").prev().show();
		});
	});
	
	// 댓글 수정 버튼 클릭 이벤트
	$(".reply_btn_toUpdateForm").each(function(){
		$(this).click(function(){
			let orgContent = $(this).closest("div").parent().find("input").val();
			let $textarea = $("<textarea>").attr("name","content").attr("row","3").val(orgContent);
			$(this).closest("div").parent().find(".replyContent").text('').append($textarea);
			
			$(this).closest("div").hide();
			$(this).closest("div").next().show();
		});
	});
}

// 댓글목록 불러오는 함수
function getReplyList(){
	
	let bId = $(".board_read_btns").find("a").eq(2).attr("href");
	
	$.ajax({
		url : "/replies/"+bId,
		type : "get",
		dataType : "text",
		success : function(result){
			let obj = JSON.parse(result);
			replyListRender(obj);
		}
	});
	
}

///////////////////////////////////////////////////////////////////////////////////////
$(function(){
	
	// 댓글목록 불러옴.
	getReplyList();
	
	// 댓글 등록 이벤트
	$("#reply_btn_insert").click(function(){
		
		let bId = $(".board_read_btns").find("a").eq(2).attr("href"); // 세번째 a태그 href값
		let $writer = $(".board_read_replyForm").find("input"); // class가 board_read_replyForm인 요소에서 input태그를 찾음.
		let $content = $(".board_read_replyForm").find("textarea"); // class가 board_read_replyForm인 요소에서 textarea태그를 찾음.
		
		// writer와 content 모두 비어있지 않으면...
		if ($writer != '' && $content != '') {
			$.ajax({
				url: "/replies/",
				type: "post",
				data: JSON.stringify({
					bId: bId,
					writer: $writer.val(),
					content: $content.val()
				}),
				headers: {
					"Content-Type": "application/json",
					"X-HTTP-Method-Override": "POST"
				},
				dataType: "text",
				success: function(result) {
					// ajax통신 성공하면 댓글목록 불러옴
					getReplyList();

					// ajax통신 성공하면 값 비우기
					$writer.val('');
					$content.val('');
				}
			});
		}
		
	});
	
	
	
});