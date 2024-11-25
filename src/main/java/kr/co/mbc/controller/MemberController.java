package kr.co.mbc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.mbc.entity.MemberEntity;
import kr.co.mbc.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@PostMapping("/update")
	public String update(MemberEntity memberEntity) {
		
		MemberEntity entity = memberService.findByUsername(memberEntity.getUsername());
		
		entity.setName(memberEntity.getName());
		
		memberService.update(entity);
		
		return "redirect:/member/read/"+memberEntity.getUsername();
	}
	
	@GetMapping("/update/{username}")
	public String update(@PathVariable("username") String username, Model model) {
		
		MemberEntity memberEntity = memberService.findByUsername(username);
		model.addAttribute("entity", memberEntity);
		
		return "/member/update";
	}
	
	@GetMapping("/read/{username}")
	public String read(@PathVariable("username") String username, Model model) {
		
		MemberEntity memberEntity = memberService.findByUsername(username);
		model.addAttribute("entity", memberEntity);
		
		return "/member/read";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		
		List<MemberEntity> memberlist = memberService.findAll();
		model.addAttribute("memberList", memberlist);
		
		return "/member/list";
	}
	
	@PostMapping("/insert")
	public String insert(MemberEntity memberEntity) {
		
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String naljja = sdf.format(d);
		
		memberEntity.setCreateDate(naljja);
		
		memberService.save(memberEntity);
		
		return "redirect:/member/list";
	}
	
	@GetMapping("/insert")
	public String insert() {
		return "/member/insert";
	}
}
