package com.fwebapp.insta.Service;

import com.fwebapp.insta.Entity.InstaUser;

public interface InstaServiceInterface {

	public int createProfile(InstaUser iu) throws Exception;
	public boolean loginProfile(InstaUser iu) throws Exception;
}
