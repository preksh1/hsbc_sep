package com.insta_java.controller;

import java.util.List;

import com.insta_java.entity.InstaUser;

public interface InstaControllerInterface {
	void createProfile() throws Exception;
	void viewProfile() throws Exception;
	void editProfile() throws Exception;
	void deleteProfile() throws Exception;
	void searchProfile() throws Exception;
	void viewAllProfile() throws Exception;
	void viewhistory() throws Exception;

}
