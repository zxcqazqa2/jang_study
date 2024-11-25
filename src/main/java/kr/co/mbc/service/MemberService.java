package kr.co.mbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.mbc.entity.MemberEntity;
import kr.co.mbc.repository.MemberRepository;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;

	public void save(MemberEntity memberEntity) {
		memberRepository.save(memberEntity);
	}

	public List<MemberEntity> findAll() {
		return memberRepository.findAll();
	}

	public MemberEntity findByUsername(String username) {
		return memberRepository.findByUsername(username);
	}
	
}
