package com.sintoburi.constant;

public enum JwtConst {

	ACCESS_TOKEN("at", "access-token"),
	REFRESH_TOKEN("rt", "refresh-token");
	
	private final String shortName;
	private final String name;
	
	JwtConst(String shortName, String name) {
		this.shortName = shortName;
		this.name = name;
	}
	
	public String getShortName() {
		return shortName;
	}
	
	public String getName() {
		return name;
	}
	
	
}
