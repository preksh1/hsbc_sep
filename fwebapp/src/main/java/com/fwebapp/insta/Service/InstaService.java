package com.fwebapp.insta.Service;

import com.fwebapp.insta.Dao.InstaDao;
import com.fwebapp.insta.Dao.InstaDaoInterface;
import com.fwebapp.insta.Entity.InstaUser;

public class InstaService implements InstaServiceInterface {

	InstaDaoInterface id=new InstaDao();
	@Override
	public int createProfile(InstaUser iu) throws Exception {
		// TODO Auto-generated method stub
		return id.createProfileDao(iu);
	}

	@Override
	public boolean loginProfile(InstaUser iu) throws Exception {
		// TODO Auto-generated method stub
		return id.loginProfileDao(iu);
	}
	

}
