package kr.co.mbc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import kr.co.mbc.entity.BoardEntity;
import kr.co.mbc.entity.CateEntity;
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

	public BoardEntity findById(Long id) {
		Optional<BoardEntity> opt = boardRepository.findById(id);
		
		if(opt.isPresent()) {
			BoardEntity boardEntity = opt.get();
			return boardEntity;
		}
		
		return null;
	}

	public void deleteById(Long id) {
		boardRepository.deleteById(id);
	}

	public List<BoardEntity> findByCate(CateEntity cateEntity) {
		return boardRepository.findByCate(cateEntity);
	}
	
}
