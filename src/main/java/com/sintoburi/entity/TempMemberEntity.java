package com.sintoburi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "member")
@Entity
//@Builder
public class TempMemberEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 20, nullable = false)
	private String username;
	
	@Column(length = 20, nullable = true)
	private String email;

	@Column(length = 100, nullable = true)
	private String oauthUserId;
	
	@Column(length = 100, nullable = false) 
	private String password;

	@Column(length = 20, nullable = true)
	private String nickname;

	@Column(length = 10, nullable = true)
	private Integer point;
	
	@Column
	private Date lastLoginDate;

	@Column
	private Date createdDate;

	@Column
	private Date updatedDate;
	
	@Builder
	public TempMemberEntity(Long id, String username, String email, String password) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
}
