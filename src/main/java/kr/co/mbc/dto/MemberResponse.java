package kr.co.mbc.dto;

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
public class MemberResponse {

	private String username;
	
	private String name;
	
	private String createDate;

	@Override
	public String toString() {
		return "MemberResponse [username=" + username + ", name=" + name + ", createDate=" + createDate + "]";
	}
	
	
}
