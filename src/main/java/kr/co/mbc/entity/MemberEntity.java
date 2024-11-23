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

/*
 * 작성자 : 봉준
 * 생성날짜 : 2024-11-23
 * 회원정보 엔티티 클래스이고, 데이터베이스의 tbl_member테이블
 * 
 * id : 기본키
 * username : 유저네임
 * pass : 비밀번호
 * name : 이름
 * createDate : 가입일
 * 
 * */

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
	private String pass;
	
	@Column(nullable = false)
	private String name;
	
	private String createDate;

	@Override
	public String toString() {
		return "MemberEntity [id=" + id + ", username=" + username + ", pass=" + pass + ", name=" + name
				+ ", createDate=" + createDate + "]";
	}
	
}
