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
public class MemberForm {

	
	private String username;
	
	private String password;
	
	private String name;

	@Override
	public String toString() {
		return "MemberForm [username=" + username + ", password=" + password + ", name=" + name + "]";
	}
	
	
}
