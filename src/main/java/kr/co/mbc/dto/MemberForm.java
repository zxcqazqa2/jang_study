package kr.co.mbc.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

	@NotBlank(message = "username은 필수항목입니다.")
	@Size(min = 4, message = "4자 이상 입력하세요.")
	private String username;
	
	@NotBlank(message = "password는 필수항목입니다.")
	private String password;
	
	@NotBlank(message = "password2는 필수항목입니다.")
	private String password2;
	
	@NotBlank(message = "name은 필수항목입니다.")
	private String name;

	@Override
	public String toString() {
		return "MemberForm [username=" + username + ", password=" + password + ", name=" + name + "]";
	}
	
	
}
