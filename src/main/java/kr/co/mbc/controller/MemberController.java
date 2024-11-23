package kr.co.mbc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	
	// 회원가입 처리
	@PostMapping("/insert")
	public String insert(MemberEntity memberEntity) {
		//System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+memberEntity);
		
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String naljja = sdf.format(d);
		
		memberEntity.setCreateDate(naljja);
		
		memberService.createMember(memberEntity);
		
		return "/member/insert";
	}
	
	// 회원가입 화면으로 이동
	@GetMapping("/insert")
	public String insert() {
		
		return "/member/insert";
	}
	
}
