package com.sintoburi.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "admin_role")
@Entity
@Builder
public class AdminRoleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Integer code;
	
	@Column
	private String role;

	@Column
	private String description;
	
	@Column
	private Long memberId;
	
	@Column
	private LocalDateTime createdDate;

	@Column
	private LocalDateTime updatedDate;
	
	@Builder
	public AdminRoleEntity(Integer code, String role, String description, Long memberId) {
		this.code = code;
		this.role = role;
		this.description = description;
		this.memberId = memberId;
	}
	
}
