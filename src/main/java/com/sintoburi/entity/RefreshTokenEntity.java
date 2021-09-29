package com.sintoburi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	private String id;

	@Column
	public Integer accessTokenId;
	
	@Column
	public Boolean isRevoked;
	
	@Column
	private Date expiredDate;
	
	@Column
	private Date createdDate;

	@Column
	private Date updatedDate;
	
	@Builder
	public RefreshTokenEntity(String id) {
		this.id = id;
	}
	
}
