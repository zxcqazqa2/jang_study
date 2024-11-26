package kr.co.mbc.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.mbc.dto.BoardForm;
import kr.co.mbc.dto.BoardResponse;
import kr.co.mbc.entity.BoardEntity;
import kr.co.mbc.entity.MemberEntity;
import kr.co.mbc.service.BoardService;
import kr.co.mbc.service.MemberService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/list")
	public String list(Model model) {
		
		List<BoardEntity> boardEntityList = boardService.findAll();
		
		List<BoardResponse> boardList = new ArrayList<BoardResponse>();
		for (BoardEntity boardEntity : boardEntityList) {
			BoardResponse boardResponse = BoardEntity.toBoardResponse(boardEntity);
			boardList.add(boardResponse);
		}
		
		model.addAttribute("boardList", boardList);
		
		return "/board/list";
	}
	
	
	@PostMapping("/insert")
	public String insert(BoardForm boardForm) {
		
		BoardEntity boardEntity = BoardEntity.toBoardEntity(boardForm);
		
		MemberEntity memberEntity = memberService.findByUsername(boardForm.getWriter());
		
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String naljja = sdf.format(d);
		
		boardEntity.setWriteDate(naljja);
		boardEntity.setMember(memberEntity);
		
		boardService.save(boardEntity);
		
		return "/board/insert";
	}
	
	@GetMapping("/insert")
	public String insert() {
		return "/board/insert";
	}
}
