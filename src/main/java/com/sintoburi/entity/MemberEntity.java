package com.sintoburi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "member")
public class MemberEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 20, nullable = false)
	private String username;
	
	@Column(length = 20, nullable = true)
	private String email;
	
	@Column(length = 100, nullable = false) 
	private String password;

	private LocalDateTime createdDate = LocalDateTime.now();
	private LocalDateTime updatedDate = LocalDateTime.now();


	
}
