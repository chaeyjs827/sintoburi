package com.sintoburi.constant;

public enum UserStatusConst {
	
	NORMAL_USER("normal", "100"),
	BLOCKED_USER("block", "101"),
	WITHDRAWAL_USER("withdrawal", "102"),
	DORMANT_USER("dormant", "103")
	;
	
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
