package com.howieLuk.spring_exec.exec.pojo;


public class User {
	private long id;
	private String username;
	private String email;
	private String password;
	private long createTime;
	
	public User() {}
	
	public User(String username, String email, String password, long createTime) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.createTime = createTime;
	}
	
	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	public User(String username, String email) {
		this.username = username;
		this.email = email;
		this.password = "123456";
		this.createTime = System.currentTimeMillis();
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public long getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", createTime=" + createTime + "]";
	}
	
}
