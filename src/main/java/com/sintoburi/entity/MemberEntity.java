package com.sintoburi.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MemberEntity {

	@Id
	private Integer id;
	
	private String username;
	
}
