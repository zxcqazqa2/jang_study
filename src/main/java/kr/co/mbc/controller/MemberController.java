package kr.co.mbc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.mbc.entity.MemberEntity;
import kr.co.mbc.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@PostMapping("/insert")
	public String insert(MemberEntity memberEntity) {
		
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String naljja = sdf.format(d);
		
		memberEntity.setCreateDate(naljja);
		
		memberService.save(memberEntity);
		
		return "/member/insert";
	}
	
	@GetMapping("/insert")
	public String insert() {
		return "/member/insert";
	}
}
