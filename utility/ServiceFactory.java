package com.insta_java.utility;

import com.insta_java.service.InstaService;
import com.insta_java.service.InstaServiceInterface;

public class ServiceFactory {
	
	private ServiceFactory(){
		
	}
	public static InstaServiceInterface createObject(String nn) {
		InstaServiceInterface is=null;
		if (nn.equals("adminservice")) {
			is=new InstaService();
		}
		return is;
	}
	
}
