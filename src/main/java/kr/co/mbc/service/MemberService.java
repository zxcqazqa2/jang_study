package kr.co.mbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.mbc.entity.MemberEntity;
import kr.co.mbc.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;

	public void createMember(MemberEntity memberEntity) {
		memberRepository.save(memberEntity);
	}

	public List<MemberEntity> getMemberList() {
		List<MemberEntity> memberList = memberRepository.findAll();
		return memberList;
	}
	
}
