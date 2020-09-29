package com.fwebapp.Service;

import java.util.List;

import com.fwebapp.Entity.fbuser;

public interface ServiceInterface {

	public int createProfile(fbuser fu) throws Exception;
	public int deleteProfile(fbuser fu);
	public fbuser viewProfile(fbuser fu);
	public List<fbuser> viewAllProfile();
	public boolean loginProfile(fbuser fu) throws Exception;
	public boolean checkProfile(fbuser fu) throws Exception;
	public List<String> getCountries() throws Exception;
	public List<String> getStation(fbuser fu) throws Exception;
}
