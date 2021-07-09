package com.legacy.sm.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AutoLoginEntity {
	
	@Id
	private Integer id;
	
	private Integer memberId;
	
	private String autoLoginKey;
	private String autoLoginIp;
	private Date autoLoginDate;
	
}
