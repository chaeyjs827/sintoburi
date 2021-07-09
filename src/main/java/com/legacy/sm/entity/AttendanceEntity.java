package com.legacy.sm.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AttendanceEntity {
	
	@Id
	private Integer id;
	
	private Integer memberId;
	
	
}
