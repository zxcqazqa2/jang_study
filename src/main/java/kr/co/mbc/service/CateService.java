package kr.co.mbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.mbc.entity.CateEntity;
import kr.co.mbc.repository.CateRepository;

@Service
public class CateService {

	@Autowired
	private CateRepository cateRepository;

	public CateEntity findByName(String cName) {
		return cateRepository.findByName(cName);
	}
}
