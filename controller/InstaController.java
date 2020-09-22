package com.insta_java.controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.insta_java.entity.InstaUser;
import com.insta_java.service.InstaService;
import com.insta_java.service.InstaServiceInterface;
import com.insta_java.utility.InstaException;
import com.insta_java.utility.ServiceFactory;
import com.insta_java.utility.sortby_email;

public class InstaController implements InstaControllerInterface {

		private InstaServiceInterface is;
		
		public InstaController() {
			// is = new InstaService();
			is=ServiceFactory.createObject("adminservice");
		}
		
		

	@Override
	public void createProfile() {
		// TODO Auto-generated method stub
		try {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		System.out.println("input the name");
		String name=br.readLine();
		
		System.out.println("input the email");
		String email=br.readLine();
		
		System.out.println("input the password");
		String password=br.readLine();
		
		InstaUser iu = new InstaUser();
		
		iu.setName(name);
		iu.setEmail(email);
		iu.setPassword(password);
		int i= is.createProfileService(iu);
		if(i>0) {
			System.out.println("created profile");
		}
		else 
		{
			System.out.println("could not create profile");
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void viewProfile(){
		// TODO Auto-generated method stub
		

		//view profile
		try {
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				System.out.println("get the email to search");
				String email=br.readLine();
				InstaUser iu=new InstaUser();
				iu.setEmail(email);
				InstaUser iu1=is.viewProfileService(iu);
				if(iu1!=null) {
					System.out.println("user info is below");
					System.out.println("name is: "+iu1.getName()+ ", email is: "+iu1.getEmail()+", password is: "+iu1.getPassword());
				}
				else {
					System.out.println("profile not found!");
				}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}


	@Override
	public void editProfile(){
		// TODO Auto-generated method stub
	//	is.editProfileService();
	//	System.out.println("profile edited");
		
		try {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("get the name to edit");
		String name=br.readLine();
		InstaUser iu=new InstaUser();
		iu.setName(name);
		List<InstaUser> l=is.searchProfileService(iu);
		if(l.size()>=1) {
			
		System.out.println(l.size()+" user found");
		for(InstaUser ll:l) {
		
			System.out.println("****************************************");
			System.out.println("Name is : "+ll.getName());
			System.out.println("Password is : "+ll.getPassword());
			System.out.println("Email is : "+ll.getEmail());
			System.out.println("****************************************");
		}
		String p="y";
		while(p.equals("y")) {
			System.out.println("what needs to be edited? press 1 to edit name,press 2 to edit password or 3 to edit email ");
			int i=Integer.parseInt(br.readLine());
			int x=0;
			switch(i)
			{
				case 1:
					iu.setChoice(1);
					System.out.println("get name to edit:");
					String s=br.readLine();
					iu.setChange(s);
					x=is.editProfileService(iu);
				break;
				case 2:
					iu.setChoice(2);
					System.out.println("get password to edit:");
					String s1=br.readLine();
					iu.setChange(s1);
					x=is.editProfileService(iu);
				break;
				case 3:
					System.out.println("get email to edit:");
					String s2=br.readLine();
					iu.setChange(s2);
					x=is.editProfileService(iu);
					break;
			}
			if(x>0) {
				System.out.println("changes made");
			}
			else{
				System.out.println("could not make the changes");
			}
			System.out.println("still want to make changes? press y for yes and n for no.");
			p=br.readLine();

			
		}
		
		}
		else 
		{
			System.out.println("profile not found");
		}
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		}
		

	@Override
	public void deleteProfile() {
		// TODO Auto-generated method stub
		try{
		System.out.println("input the email of the profile to be deleted");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String e=br.readLine();
		InstaUser iu=new InstaUser();
		iu.setEmail(e);
	//	InstaUser iu1=is.viewProfileService(iu);
		InstaUser iu1=is.viewProfileService(iu);
		System.out.println(iu1);
		if(iu1!=null) {
			int i=is.deleteProfileService(iu);
			if(i>0) 
			{
				System.out.println("profile deleted");
			}
			else {
				System.out.println("profile could not be deleted");
			}
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
//		else {
//			System.out.println("profile not found");
//		}
		
		
	}

	@Override
	/*public void searchProfile() throws Exception {
		
		//view profile
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("get the name to search");
		String name=br.readLine();
		InstaUser iu=new InstaUser();
		iu.setName(name);
		InstaUser iu1=is.searchProfileService(iu);
		if(iu1!=null) {
			System.out.println("user info is below");
			System.out.println("name is: "+iu1.getName()+ ", email is: "+iu1.getEmail()+", password is: "+iu1.getPassword());
		}
		else {
			System.out.println("profile not found!");
		}
		
		// TODO Auto-generated method stub
		is.searchProfileService(iu1);
		System.out.println("profile searched");
		
	}*/
		public void searchProfile()  {
		
		//view profile
		try {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("get the name to search");
		String name=br.readLine();
		InstaUser iu=new InstaUser();
		iu.setName(name);
		List<InstaUser> l=is.searchProfileService(iu);
		System.out.println(l.size()+" user found");
		for(InstaUser ll:l) {
		
			System.out.println("****************************************");
			System.out.println("Name is : "+ll.getName());
			System.out.println("Password is : "+ll.getPassword());
			System.out.println("Email is : "+ll.getEmail());
			System.out.println("****************************************");
		
		}
		}
		
		catch(IOException e) {
			System.out.println("custom exception occured "+e);
		}
		catch(InstaException e) {
			System.out.println("custom exception occured for <3"+e.uu());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
		
		// TODO Auto-generated method stub
		//is.searchProfileService(iu1);
		//System.out.println("profile searched");
	

	@Override
	public void viewAllProfile(){
		// TODO Auto-generated method stub
		
		String s=null;
		try {
			/*
			ll= is.viewAllProfileService();
			//Collections.sort(l,new sortby_email());
			int i=1;
		for(String l:ll) {
			System.out.println("info for profile "+i);
			System.out.println(l);
			i+=1;
		}*/
			s=is.viewAllProfileService();
			System.out.println(s);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	/*public void viewAllProfile(){
		// TODO Auto-generated method stub
		
		List<InstaUser> l=null;
		try {
			l= is.viewAllProfileService();
			//Collections.sort(l,new sortby_email());
		for(InstaUser ll:l) {
			System.out.println("Name is: "+ll.getName());
			System.out.println("Password is: "+ll.getPassword());
			System.out.println("Email is: "+ll.getEmail());
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}*/
	public void viewhistory() throws Exception {
		Map<String,List<InstaUser>> m=is.viewhistoryservice();
		List<InstaUser> i=m.get("proflist");
		for(InstaUser ii:i) {
			System.out.println("Name is: "+ii.getName());
			System.out.println("Password is: "+ii.getPassword());
			System.out.println("Email is: "+ii.getEmail());
		}
		List<InstaUser> i1=m.get("studentlist");
		for(InstaUser l:i1) {
			System.out.println("Name is: "+l.getName());
			System.out.println("Password is: "+l.getPassword());
			System.out.println("Email is: "+l.getEmail());
		}
		
	}


}
