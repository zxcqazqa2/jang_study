package kr.co.mbc.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@PostMapping("/delete")
	public String delete(Long id) {
		
		boardService.deleteById(id);
		
		return "redirect:/board/list";
	}
	
	@PostMapping("/update")
	public String update(Long id ,BoardForm boardForm) {
		
		BoardEntity boardEntity = boardService.findById(id);
		boardEntity.setTitle(boardForm.getTitle());
		boardEntity.setContent(boardForm.getContent());
		
		boardService.save(boardEntity);
		
		return "redirect:/board/read/"+boardEntity.getId();
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable("id") Long id, Model model) {
		
		BoardEntity boardEntity = boardService.findById(id);
		
		BoardResponse boardResponse = BoardEntity.toBoardResponse(boardEntity); // <-- 자동완성 또 안됨
		
		model.addAttribute("boardResponse", boardResponse);
		
		return "/board/update";
	}
	
	@GetMapping("/read/{id}")
	public String read(@PathVariable("id") Long id, Model model) {
		
		BoardEntity boardEntity = boardService.findById(id);
		
		BoardResponse boardResponse = BoardEntity.toBoardResponse(boardEntity); // <-- 왜 자동완성이 안되나?
		
		model.addAttribute("boardResponse", boardResponse);
		
		return "/board/read";
	}
	
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
