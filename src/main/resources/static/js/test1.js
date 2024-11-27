console.log("test1.js파일 불러옴.");

function replyListRender(obj){
	let tag = ``;
	for(el of obj){
		tag+=`
			<div>
				작성자 : ${el.writer}<br>
				내용 : ${el.content}
			</div>
		`
	}
	$(".replyList").html(tag);
}

function getReplyList(bId){
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

$(function(){
	
	$("#reply_btn_insert").click(function(){
		let bId = $("a").eq(2).attr("href");
		let writer = $(".board_read_replyForm").find("input").val();
		let content = $(".board_read_replyForm").find("textarea").val();
		
		$.ajax({
			url : "/replies/",
			type : "post",
			data : JSON.stringify({
				bId : bId,
				writer : writer,
				content : content
			}),
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},
			dataType : "text",
			success : function(result){
				getReplyList(bId);
			}
		});
	});
	
	
	
	
});