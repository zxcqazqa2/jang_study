package kr.co.mbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.mbc.entity.BoardEntity;
import kr.co.mbc.repository.BoardRepository;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;

	public void save(BoardEntity boardEntity) {
		boardRepository.save(boardEntity);
	}

	public List<BoardEntity> findAll() {
		return boardRepository.findAll();
	}
	
}
