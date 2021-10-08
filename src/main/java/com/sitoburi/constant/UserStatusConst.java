package com.sitoburi.constant;

public enum UserStatusConst {
	
	BLOCKED_USER("block", "401"),
	WITHDRAWAL_USER("withdrawal", "444");
	
	private final String name;
	private final String code;
	
	UserStatusConst(String name, String code) {
		this.name = name;
		this.code = code;
	}

	public String getName() {
		return name;
	}
	
	public String getCode() {
		return code;
	}
	
	
}
