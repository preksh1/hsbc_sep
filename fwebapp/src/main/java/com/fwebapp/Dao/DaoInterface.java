package com.fwebapp.Dao;

import java.util.List;

import com.fwebapp.Entity.fbuser;

public interface DaoInterface {

	public int createProfileDao(fbuser fu) throws Exception;
	public int deleteProfileDao(fbuser fu);
	public fbuser viewProfileDao(fbuser fu);
	public List<fbuser> viewAllProfileDao();
	public boolean loginProfile(fbuser fu) throws Exception;
}
