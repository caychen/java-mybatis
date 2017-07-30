package org.com.cay.entity;

import java.io.Serializable;

public class Users  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int uid;
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	@Override
	public String toString() {
		return "Users [uid=" + uid + ", username=" + username + ", password=" + password + "]";
	}
	
}
