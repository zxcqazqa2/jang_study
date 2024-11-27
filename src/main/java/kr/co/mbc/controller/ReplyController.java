package kr.co.mbc.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.mbc.dto.ReplyResponse;
import kr.co.mbc.entity.BoardEntity;
import kr.co.mbc.entity.MemberEntity;
import kr.co.mbc.entity.ReplyEntity;
import kr.co.mbc.service.BoardService;
import kr.co.mbc.service.MemberService;
import kr.co.mbc.service.ReplyService;

@RestController
@RequestMapping("/replies")
public class ReplyController {

	@Autowired
	private ReplyService replyService;
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private MemberService memberService;
	
	@DeleteMapping("/")
	public String delete(@RequestBody Map<String, String> map) {
		Long id = Long.parseLong((String) map.get("id"));
		replyService.deleteById(id);
		
		return "ok";
	}
	
	@PutMapping("/")
	public String update(@RequestBody Map<String, String> map) {
		Long id = Long.parseLong((String) map.get("id"));
		String content = map.get("content");
		
		ReplyEntity replyEntity = replyService.findById(id);
		replyEntity.setContent(content);
		replyService.save(replyEntity);
		
		return "ok";
	}
	
	@GetMapping("/{bId}")
	public List<ReplyResponse> list(@PathVariable("bId")Long bId) {
		BoardEntity boardEntity = boardService.findById(bId);
		
		List<ReplyEntity> replyEntityList = replyService.findByBoard(boardEntity);
		List<ReplyResponse> replyList = new ArrayList<ReplyResponse>();
		for (ReplyEntity replyEntity : replyEntityList) {
			ReplyResponse replyResponse = ReplyEntity.toReplyResponse(replyEntity);
			replyList.add(replyResponse);
		}
		
		return replyList;
	}
	
	@PostMapping("/")
	public String insert(@RequestBody Map<String, String> map) {
		
		Long bId = Long.parseLong((String)map.get("bId"));
		BoardEntity boardEntity = boardService.findById(bId);
		
		String writer = map.get("writer");
		MemberEntity memberEntity = memberService.findByUsername(writer);
		
		String content = map.get("content");
		
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String naljja = sdf.format(d);
		
		ReplyEntity replyEntity = new ReplyEntity(null, content, naljja, memberEntity, boardEntity);
		
		replyService.save(replyEntity);
		
		return "ok";
	}
}
