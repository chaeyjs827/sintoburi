package com.legacy.sm.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BannerLog {

	@Id
	private Integer id;
	
	private Integer bannerId;
	
	private Integer memberId;
	
	private Date clickedDate;
	private String clickedIp;
	private String originAddress;
	private String forwardAddress;
		
}
