package com.szymonharabasz.miniforum;

import java.util.Date;

public class User {
	private long id;
	private String username;
	private String password;
	private String info;
	private Date joined;
	public User(long l) {
		this.id = l;
		this.username = "";
		this.password = "";
		this.info = "";
		this.joined = new Date();
	}	
	public User(long id, String username, String password, String info, Date joined) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.info = info;
		this.joined = joined;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Date getJoined() {
		return joined;
	}
	public void setJoined(Date joined) {
		this.joined = joined;
	}
}
