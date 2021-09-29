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
@Table(name = "login_history")
@Entity
@Builder
public class LoginHistoryEntity {

	@Id
	private String id;

	@Column
	public Integer memberId;

	@Column
	public String deviceUuid;

	@Column
	public String deviceModel;
	
	@Column
	public String ipAddress ;
	
	@Column
	private Date createdDate;

	@Column
	private Date updatedDate;
	
	@Builder
	public LoginHistoryEntity(String id) {
		this.id = id;
	}
	
}
