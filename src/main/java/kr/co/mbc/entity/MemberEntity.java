package kr.co.mbc.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import kr.co.mbc.dto.MemberForm;
import kr.co.mbc.dto.MemberResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_member")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class MemberEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String name;
	
	private String createDate;
	
	@OneToMany(mappedBy = "member")
	@JsonIgnore
	private List<BoardEntity> boardList;

	@Override
	public String toString() {
		return "MemberEntity [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", createDate=" + createDate + "]";
	}
	
	public static MemberResponse toMemberResponse(MemberEntity memberEntity) {
		return MemberResponse.builder()
				.username(memberEntity.getUsername())
				.name(memberEntity.getName())
				.createDate(memberEntity.getCreateDate())
				.build();
	}
	
	public static MemberEntity toMemberEntity(MemberForm memberForm) {
		return MemberEntity.builder()
				.username(memberForm.getUsername())
				.password(memberForm.getPassword())
				.name(memberForm.getName())
				.build();
	}
	
}
