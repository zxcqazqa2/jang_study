package kr.co.mbc.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import kr.co.mbc.dto.BoardForm;
import kr.co.mbc.dto.BoardResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_board")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BoardEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String title;
	
	private String content;
	
	private String writeDate;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "cate_id")
	private CateEntity cate;
	
	@OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<ReplyEntity> replyList;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "member_id")
	private MemberEntity member;
	
	
	public static BoardResponse toBoardResponse(BoardEntity boardEntity) {
		return BoardResponse.builder()
				.id(boardEntity.getId())
				.cName(boardEntity.getCate().getName())
				.title(boardEntity.getTitle())
				.content(boardEntity.getContent())
				.writer(boardEntity.getMember().getUsername())
				.writeDate(boardEntity.getWriteDate())
				.build();
	}
	
	public static BoardEntity toBoardEntity(BoardForm boardForm) {
		return BoardEntity.builder()
				.title(boardForm.getTitle())
				.content(boardForm.getContent())
				.build();
	}
}
