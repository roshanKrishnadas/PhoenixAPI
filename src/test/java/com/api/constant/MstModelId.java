package com.api.constant;

public enum MstModelId {
 Nexus_2blue(1),gallexy(2);
	int code;
	private MstModelId(int code) {
		this.code=code;
	}
	public int getMstModelId() {
		return code;
	}
}
