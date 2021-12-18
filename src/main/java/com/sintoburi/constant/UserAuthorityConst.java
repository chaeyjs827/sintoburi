package com.sintoburi.constant;

public enum UserAuthorityConst {

	ADMIN("admin"),
	NORMAL("normal");

	private final String value;

	UserAuthorityConst(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
