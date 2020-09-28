package com.fwebapp.Service;

import java.util.List;

import com.fwebapp.Dao.DaoInterface;
import com.fwebapp.Entity.fbuser;
import com.fwebapp.Utility.DaoFactory;

public class Service implements ServiceInterface{

	DaoInterface di=null;
	public Service() throws Exception {
	di=DaoFactory.createObject("admin");
	}
	public int createProfile(fbuser fu) throws Exception {
		
		return di.createProfileDao(fu);
	}

	public int deleteProfile(fbuser fu) {
		
		return di.deleteProfileDao(fu);
	}

	public fbuser viewProfile(fbuser fu) {
		
		return di.viewProfileDao(fu);
	}

	public List<fbuser> viewAllProfile() {
		// TODO Auto-generated method stub
		return di.viewAllProfileDao();
	}
	@Override
	public boolean loginProfile(fbuser fu) throws Exception {
		// TODO Auto-generated method stub
		return di.loginProfile(fu);
	}

	
}
