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
@Table(name = "admin_history")
@Entity
@Builder
public class AdminHistoryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Long memberId;
	
	@Column
	private Integer originCode;
	
	@Column
	private Integer newCode;
	
	@Column
	private LocalDateTime createdDate;

	@Column
	private LocalDateTime updatedDate;
	
	@Builder
	public AdminHistoryEntity(Long memberId, Integer originCode, Integer newCode) {
		this.memberId = memberId;
		this.originCode = originCode;
		this.newCode = newCode;
		this.memberId = memberId;
	}
	
}
