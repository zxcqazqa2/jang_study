package kr.co.mbc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.mbc.entity.BoardEntity;
import kr.co.mbc.entity.CateEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, Long>{

	List<BoardEntity> findByCate(CateEntity cateEntity);

}
