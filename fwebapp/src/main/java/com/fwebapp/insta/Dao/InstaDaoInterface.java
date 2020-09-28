package com.fwebapp.insta.Dao;

import com.fwebapp.insta.Entity.InstaUser;

public interface InstaDaoInterface {
	public int createProfileDao(InstaUser iu) throws Exception;
	public boolean loginProfileDao(InstaUser iu) throws Exception;

}
