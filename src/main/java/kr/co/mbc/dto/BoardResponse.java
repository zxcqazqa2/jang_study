package kr.co.mbc.dto;

import java.util.List;

import kr.co.mbc.entity.ReplyEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BoardResponse {

	private Long id;
	
	private String cName;
	
	private String title;
	
	private String content;
	
	private String writer;
	
	private String writeDate;
	
	private List<ReplyEntity> replyList;
}
