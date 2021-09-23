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
@Table(name = "oauth_member")
@Entity
@Builder
public class OauthMember {

	@Id
	private Integer id;

	@Column
	public Integer memberId;
	
	@Column
	public String oauthName;

	@Column
	public String secretKey;
	
	@Column
	public String redirectUrl;
	
	@Column
	private Date expiredDate;
	
	@Column
	private Date createdDate;

	@Column
	private Date updatedDate;
	
	@Builder
	public OauthMember(Integer id) {
		this.id = id;
	}
	
}
