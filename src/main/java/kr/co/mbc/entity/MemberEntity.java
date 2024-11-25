package kr.co.mbc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

	@Override
	public String toString() {
		return "MemberEntity [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", createDate=" + createDate + "]";
	}
	
	
}
