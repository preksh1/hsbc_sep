package com.fwebapp.Utility;

import com.fwebapp.Service.Service;
import com.fwebapp.Service.ServiceInterface;

public class ServiceFactory {
	
	public static ServiceInterface createObject(String n) throws Exception {
		ServiceInterface si=null;
		if(n.equalsIgnoreCase("admin")) {
			si=new Service();
		}
		return si;
	}

}
