package com.sintoburi.entity;

import java.time.LocalDateTime;
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
@Table(name = "oauth_access_token")
@Entity
@Builder
public class AccessTokenEntity {

	@Id
	private String id;

	@Column(nullable = true)
	public Integer memberId;
	
	@Column(nullable = true)
	public Boolean isRevoked;
	
	@Column(nullable = true)
	private Date expiredDate;

	@Column(nullable = true)
	private LocalDateTime createdDate;

	@Column(nullable = true)
	private LocalDateTime updatedDate;
	
	
	@Builder
	public AccessTokenEntity(String id, Integer memberId, Boolean isRevoked
			,Date expiredDate) {
		this.id = id;
		this.memberId = memberId;
		this.expiredDate = expiredDate;
		this.createdDate = LocalDateTime.now();
		this.updatedDate = LocalDateTime.now();
	}
	
}
