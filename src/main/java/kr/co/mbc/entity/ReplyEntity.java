package kr.co.mbc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import kr.co.mbc.dto.ReplyResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_reply")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ReplyEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String content;
	
	private String writeDate;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "member_id")
	private MemberEntity member;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "board_id")
	private BoardEntity board;
	
	public static ReplyResponse toReplyResponse(ReplyEntity replyEntity) {
		 ReplyResponse replyResponse = ReplyResponse.builder()
				.id(replyEntity.getId())
				.content(replyEntity.getContent())
				.writeDate(replyEntity.getWriteDate())
				.writer(replyEntity.getMember().getUsername())
				.build();
		 return replyResponse;
	}
}
