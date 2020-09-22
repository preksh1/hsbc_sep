package com.insta_java.dao;

import java.util.List;
import java.util.Map;

import com.insta_java.entity.InstaUser;
import com.insta_java.utility.InstaException;

public interface InstaDaoInterface {
	int createProfileDao(InstaUser iu) throws Exception ;
	InstaUser viewProfileDao(InstaUser iu) ;
	int editProfileDao(InstaUser iu) ;
	int deleteProfileDao(InstaUser iu) ;
	List<InstaUser> searchProfileDao(InstaUser iu) throws InstaException ;
	//List<InstaUser> viewAllProfileDao() throws Exception ;
	String viewAllProfileDao() throws Exception ;
	Map<String, List<InstaUser>> viewhistorydao() throws Exception;

}
