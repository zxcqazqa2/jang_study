package kr.co.mbc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.mbc.entity.MemberEntity;
import kr.co.mbc.service.MemberService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;
	
	// 회원정보 상세보기 화면으로 이동
	@GetMapping("/read/{username}")
	public String read(@PathVariable("username") String username, Model model) {
		MemberEntity memberEntity = memberService.findByUsername(username);
		
		model.addAttribute("entity", memberEntity);
		
		return "/member/read";
	}
	
	// 회원목록 화면으로 이동
	@GetMapping("/list")
	public String list(Model model) {
		
		List<MemberEntity> memberList = memberService.getMemberList();
		
		model.addAttribute("memberList", memberList);
		
		return "/member/list";
	}
	
	// 회원가입 처리
	@PostMapping("/insert")
	public String insert(MemberEntity memberEntity) {
		//System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+memberEntity);
		
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String naljja = sdf.format(d);
		
		memberEntity.setCreateDate(naljja);
		
		memberService.createMember(memberEntity);
		
		return "redirect:/member/list";
	}
	
	// 회원가입 화면으로 이동
	@GetMapping("/insert")
	public String insert() {
		
		return "/member/insert";
	}
	
}
