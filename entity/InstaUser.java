package com.insta_java.entity;

public class InstaUser {
	private String name;
	private String email;
	private String password;
	private int choice;
	private String change;
	
	public String getChange() {
		return change;
	}
	public void setChange(String change) {
		this.change = change;
	}
	public int getChoice() {
		return choice;
	}
	public void setChoice(int choice) {
		this.choice = choice;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	

}
