package kr.co.mbc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.mbc.entity.BoardEntity;
import kr.co.mbc.entity.ReplyEntity;
import kr.co.mbc.repository.ReplyRepository;

@Service
public class ReplyService {

	@Autowired
	private ReplyRepository replyRepository;

	public void save(ReplyEntity replyEntity) {
		replyRepository.save(replyEntity);
	}

	public List<ReplyEntity> findByBoard(BoardEntity boardEntity) {
		return replyRepository.findByBoard(boardEntity);
	}

	public ReplyEntity findById(Long id) {
		 Optional<ReplyEntity> opt = replyRepository.findById(id);
		 
		 if(opt.isPresent()) {
			 ReplyEntity replyEntity = opt.get();
			 return replyEntity;
		 }
		 return null;
	}

	public void deleteById(Long id) {
		replyRepository.deleteById(id);
	}
}
