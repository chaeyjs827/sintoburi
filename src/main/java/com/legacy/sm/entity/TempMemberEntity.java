package com.legacy.sm.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;


/*
 * 현재 테스트 때문에 다른 Member Entity 가 존재 하기 때문에 잠시 'TempMemberEntity'로 바꿔놓음
 */
@Entity
public class TempMemberEntity {
	
	@Id
	private Integer id;
	
	private String username;
	private String password;
	private String email;
	private String realname;
	private String nickname;
	private String level;
	private String point;
	private String thumnail;
	private String snsAddress;
	private String phoneNumber;
	private String birthday;
	private String gender;
	private String address;
	
	
	// true/false 데이터. boolean할지 integer로 할지..
	private Integer receivedEmailYN;	// 이메일 수신
	private Integer receivedMessageYN;			// 메세지 수신
	private Integer receivedSmsYN;	// SMS 수신
	private Integer blockMemberYN;	// 블락 유저
	private Integer confirmedEmailYN;	// 이메일 인증
	private Integer confirmedPhoneNumber;	// 전화번호 인증
	
	private Date signupDate;
	private String signupIP;
	private Date lastLoginDate;
	private String lastLoginIP;
	
	
	
	
	
	
	
	
	
}
