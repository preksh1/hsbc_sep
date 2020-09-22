package com.insta_java.utility;

import com.insta_java.controller.InstaController;
import com.insta_java.controller.InstaControllerInterface;
import com.insta_java.dao.InstaDao;
import com.insta_java.dao.InstaDaoInterface;

public class ControllerFactory {
	private ControllerFactory() {
		
	}
	public static InstaControllerInterface createObject(String nn) {
		InstaControllerInterface ic=null;
		if(nn.equals("adminservice")) {
			ic=new InstaController();
		}
		return ic;
	}

}
