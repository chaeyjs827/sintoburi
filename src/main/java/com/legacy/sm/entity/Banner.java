package com.legacy.sm.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Banner {

	@Id
	private Integer id;
	
	private Date startedDate;
	private Date finishedDate;
	
	private String bannerGroup;
	private String title;
	private Integer newLocationYN;	// 새창 열리기
	private String device;
	private String width;
	private String height;
	private Integer hit;
	private Integer seq;
	private Integer activatedYN;	// 배너 활성화
	
	private Date createdDate;
	private String createdIp;
	private String memberId;	// 업로더
	
}
