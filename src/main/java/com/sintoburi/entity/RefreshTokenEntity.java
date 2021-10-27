package com.sintoburi.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
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
//@Builder
public class RefreshTokenEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = true)
	public String refreshTokenId;
	
	@Column(nullable = true)
	public Boolean isRevoked;
	
	@Column(nullable = true)
	private Date expiredDate;
	
	@Column
	private LocalDateTime createdDate;

	@Column
	private LocalDateTime updatedDate;
	
	@Builder
	public RefreshTokenEntity(Long id, String refreshTokenId, Boolean isRevoked
			,Date expiredDate) {
		this.id = id;
		this.refreshTokenId = refreshTokenId;
		this.isRevoked = isRevoked;
		this.expiredDate = expiredDate;
		this.createdDate = LocalDateTime.now();
		this.updatedDate = LocalDateTime.now();
	}
	
//    @PrePersist
//    public void setInsertDate() {
//        this.createdDate = LocalDateTime.now();
//        this.updatedDate = LocalDateTime.now();
//    }
	
}
