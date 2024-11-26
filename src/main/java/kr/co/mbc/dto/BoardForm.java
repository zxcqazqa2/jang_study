package kr.co.mbc.dto;

import jakarta.validation.constraints.NotBlank;
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
public class BoardForm {
	
	@NotBlank(message = "title은 필수")
	private String title;
	
	@NotBlank(message = "content는 필수")
	private String content;
	
	@NotBlank(message = "writer은 필수")
	private String writer;

	@Override
	public String toString() {
		return "BoardForm [title=" + title + ", content=" + content + ", writer=" + writer + "]";
	}

	
	
}
