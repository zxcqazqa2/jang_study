package kr.co.mbc.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.mbc.dto.MemberForm;
import kr.co.mbc.dto.MemberResponse;
import kr.co.mbc.entity.MemberEntity;
import kr.co.mbc.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/checkId")
	@ResponseBody
	public String checkId(@RequestParam Map<String, String> map) {
		String username = map.get("username");
		
		MemberEntity memberEntity = memberService.findByUsername(username);
		if(memberEntity == null) {
			return "ok";
		}
		return "no";
	}
	
	@PostMapping("/delete")
	public String delete(String username) {
		
		memberService.deleteByUsername(username);
		
		return "redirect:/member/list";
	}
	
	@PostMapping("/update")
	public String update(MemberForm memberForm) {
		
		MemberEntity memberEntity = memberService.findByUsername(memberForm.getUsername());
		
		memberEntity.setName(memberForm.getName());
		
		memberService.update(memberEntity);
		
		return "redirect:/member/read/"+memberForm.getUsername();
	}
	
	@GetMapping("/update/{username}")
	public String update(@PathVariable("username") String username, Model model) {

		MemberEntity memberEntity = memberService.findByUsername(username);
		
		MemberResponse memberResponse = MemberEntity.toMemberResponse(memberEntity);

		model.addAttribute("memberResponse", memberResponse);

		return "/member/update";
	}
	
	@GetMapping("/read/{username}")
	public String read(@PathVariable("username") String username, Model model) {
		
		MemberEntity memberEntity = memberService.findByUsername(username);
		
		MemberResponse memberResponse = MemberEntity.toMemberResponse(memberEntity);
		
		model.addAttribute("memberResponse", memberResponse);
		
		return "/member/read";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		
		List<MemberEntity> memberEntityList = memberService.findAll();
		
		List<MemberResponse> memberList = new ArrayList<>();
		for (MemberEntity memberEntity : memberEntityList) {
			MemberResponse memberResponse = MemberEntity.toMemberResponse(memberEntity);
			memberList.add(memberResponse);
		}
		
		model.addAttribute("memberList", memberList);
		
		return "/member/list";
	}
	
	@PostMapping("/insert")
	public String insert(MemberForm memberForm) {
		
		MemberEntity memberEntity = MemberEntity.toMemberEntity(memberForm);
		
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
