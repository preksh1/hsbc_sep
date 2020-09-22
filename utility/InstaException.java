package com.insta_java.utility;

public class InstaException extends Exception{
	
	private String name;
	public InstaException(String name) {
		// TODO Auto-generated constructor stub
		this.name=name;
	}
	@Override
	public String toString() {
		return "user not found issue";
	}
	
	public String uu() {
		String nn=null;
		nn="uname shud be >3";
		return nn;
	}
	public String uu1() {
		String nn=null;
		if(name.length()<8) {
			nn="shud be <8";
		}
		return nn;
	}
	
}
