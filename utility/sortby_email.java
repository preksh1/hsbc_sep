package com.insta_java.utility;

import java.util.Comparator;

import com.insta_java.entity.InstaUser;

public class sortby_email implements Comparable<InstaUser>{
	String email;
	String name;

	sortby_email(String email,String name){
		this.email=email;
		this.name=name;
	}
	/*@Override
	public int compare(InstaUser r1, InstaUser r2) {
		// TODO Auto-generated method stub
		
		return r1.getEmail().compareTo(r2.getEmail());
	}*/
	

	@Override
	public int compareTo(InstaUser f1) {
		// TODO Auto-generated method stub
		int email=this.email.compareTo
		return f.compareTo(f1);
	}
	

}
