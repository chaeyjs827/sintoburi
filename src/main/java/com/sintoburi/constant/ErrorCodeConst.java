package com.sintoburi.constant;

public enum ErrorCodeConst {

	NULL_ERROR("null-error", "500");
	
	private final String name;
	private final String code;
	
	ErrorCodeConst(String name, String code) {
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
