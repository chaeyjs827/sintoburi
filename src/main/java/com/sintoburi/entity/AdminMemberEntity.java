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
@Table(name = "admin_member")
@Entity
@Builder
public class AdminMemberEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Long memberId;

	
	@Column
	private LocalDateTime createdDate;

	@Column
	private LocalDateTime updatedDate;
	
	@Builder
	public AdminMemberEntity(Long memberId) {
		this.memberId = memberId;
	}
	
}
