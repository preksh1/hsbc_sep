package com.insta_java.service;

import java.util.List;
import java.util.Map;

import com.insta_java.entity.InstaUser;

public interface InstaServiceInterface {
	int createProfileService(InstaUser iu) throws Exception;
	InstaUser viewProfileService(InstaUser iu) throws Exception;
	int editProfileService(InstaUser iu) throws Exception;
	int deleteProfileService(InstaUser iu) throws Exception;
	List<InstaUser> searchProfileService(InstaUser iu) throws Exception;
	String viewAllProfileService() throws Exception;
	//List<InstaUser> viewAllProfileService() throws Exception;
	Map<String, List<InstaUser>> viewhistoryservice() throws Exception;
	

}
