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
@Table(name = "oauth_refresh_token")
@Entity
@Builder
public class RefreshTokenEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	public String refreshTokenId;
	
	@Column
	public Boolean isRevoked;
	
	@Column
	private Date expiredDate;
	
	@Column
	private Date createdDate;

	@Column
	private Date updatedDate;
	
	@Builder
	public RefreshTokenEntity(Long id) {
		this.id = id;
	}
	
}
