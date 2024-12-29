package com.easy.bean;

public class LoginRequest {
	private String pass;
	private String digestPass;

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getDigestPass() {
		return digestPass;
	}

	public void setDigestPass(String digestPass) {
		this.digestPass = digestPass;
	}
}
