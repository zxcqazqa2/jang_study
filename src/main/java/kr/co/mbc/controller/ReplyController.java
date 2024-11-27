package kr.co.mbc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.mbc.entity.BoardEntity;
import kr.co.mbc.entity.ReplyEntity;
import kr.co.mbc.service.BoardService;
import kr.co.mbc.service.ReplyService;

@RestController
@RequestMapping("/replies")
public class ReplyController {

	@Autowired
	private ReplyService replyService;
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/{bId}")
	public List<ReplyEntity> list(@PathVariable("bId")Long bId) {
		BoardEntity boardEntity = boardService.findById(bId);
		
		List<ReplyEntity> replyList = replyService.findByBoard(boardEntity);
		
		return replyList;
	}
	
	@PostMapping("/")
	public String insert(@RequestBody Map<String, String> map) {
		
		Long bId = Long.parseLong((String)map.get("bId"));
		BoardEntity boardEntity = boardService.findById(bId);
		
		String writer = map.get("writer");
		String content = map.get("content");
		
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String naljja = sdf.format(d);
		
		ReplyEntity replyEntity = new ReplyEntity(null, content, writer, naljja, boardEntity);
		
		replyService.save(replyEntity);
		
		return "ok";
	}
}
