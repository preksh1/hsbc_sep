package com.fwebapp.Utility;

import com.fwebapp.Dao.Dao;
import com.fwebapp.Dao.DaoInterface;

public class DaoFactory {
	
	public static DaoInterface createObject(String s) throws Exception {
		DaoInterface di=null;
		if(s.equalsIgnoreCase("admin")) {
			di=new Dao();
		}
		return di;
	}

}
