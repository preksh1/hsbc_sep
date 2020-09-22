package com.insta_java.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.insta_java.controller.InstaController;
import com.insta_java.controller.InstaControllerInterface;
import com.insta_java.utility.ControllerFactory;

public class InstaView {
	private InstaControllerInterface ic ;//keeping this as static will give null pointer exception
	public InstaView() {
		ic=ControllerFactory.createObject("adminservice");
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String cc="y";
		while(cc.equals("y")) {
		System.out.println("*********************************MAIN MENU************************");
		System.out.println("press 1 to create profile");
		System.out.println("press 2 to view profile");
		System.out.println("press 3 to edit profile");
		System.out.println("press 4 to delete profile");
		System.out.println("press 5 to search profile");
		System.out.println("press 6 to view all profiles");
		System.out.println("press 7 to view history");
		
		//InstaControllerInterface ic = new InstaController();
		InstaView iv=new InstaView();
		
		System.out.println("enter your choice ");
		int i=Integer.parseInt(br.readLine());
		switch(i)
		{
			case 1: iv.ic.createProfile();
			break;
			case 2:iv.ic.viewProfile();
			break;
			case 3:
				iv.ic.editProfile();
				break; 
			case 4:
				iv.ic.deleteProfile();
				break;
			case 5:
				iv.ic.searchProfile();
				break;
			case 6:
				iv.ic.viewAllProfile();
				break;
			case 7:
				iv.ic.viewhistory();
		}
		}
	}

}
