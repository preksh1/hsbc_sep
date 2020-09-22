package com.insta_java.dao;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.insta_java.entity.InstaUser;
import com.insta_java.utility.InstaException;

public class InstaDao implements InstaDaoInterface {	

	@Override
		public int createProfileDao(InstaUser iu) throws Exception {
		// TODO Auto-generated method stub
		File f=new File("e:/hsbc_training/w2/dao.txt");
		if(f.createNewFile()) {
			System.out.println("file created");
		}
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		FileOutputStream out = new FileOutputStream(f,true);
		//String st=br.readLine();
		
		String s= "name is :"+iu.getName()+" password is: "+iu.getPassword()+" and email is: "+iu.getEmail()+"\n";
		
		for(int i=0;i<s.length();i++) {
			out.write(s.charAt(i));
			//out.newLine();
			
		}
		//out.newLine();
		
		out.close();
		
		
		return 1;
		
		
		
		
		
		/*
		 * FOR DERBY ---------------------
		Connection con=null;
		int i=0;
		try {	
			
			
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		// create connection with db
			con=DriverManager.getConnection("jdbc:derby:e:/db2");
		// create query
			PreparedStatement ps = con.prepareStatement("insert into t1 values(?,?,?)");
			ps.setString(1, iu.getName());
			ps.setString(2, iu.getPassword());
			ps.setString(3, iu.getEmail());
			i = ps.executeUpdate();
			
		//
		 // int i=0;
		 // 
		 // System.out.println("in dao"+iu.getName()); if(iu.getName().equals("Harry")) {
		 //i=1; } return i;
		 //
	}
	

	catch(ClassNotFoundException |SQLException e) {
		e.printStackTrace();
	}
	
	finally {
		try {
			con.close();
		}
		catch(SQLException e1){
			e1.printStackTrace();
		}
		
	}
	return i;*/

}

	@Override
	public InstaUser viewProfileDao(InstaUser iu) {
		// TODO Auto-generated method stub
		Connection con=null;
		try {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		con=DriverManager.getConnection("jdbc:derby:e:/db2");
		PreparedStatement ps=con.prepareStatement("select * from t1 where email=?");
		//InstaUser iu =new InstaUser();
		ps.setString(1,iu.getEmail());
		ResultSet res= ps.executeQuery();
		InstaUser iu1=null;
		while(res.next()) {
			iu1=new InstaUser();
			iu1.setName(res.getString(1));
			iu1.setPassword(res.getString(2));
			iu1.setEmail(res.getString(2));
		}
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		finally {
			try {
				con.close();
			}
			catch(SQLException e1) {
				e1.printStackTrace();
			}
		}
		return iu;

	}

	@Override
	public int editProfileDao(InstaUser iu) {
		// TODO Auto-generated method stub
	//	System.out.println("profile edited");
		Connection con=null;
		int i=0;
		try {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		//create connection with db
		con=DriverManager.getConnection("jdbc:derby:e:/db2");
		//create query
		//PreparedStatement ps=con.prepareStatement("update table t1 set ? = ? where name =?");
		//InstaUser iu=new InstaUser();
		int c= iu.getChoice();
		String s;
		PreparedStatement ps;
		System.out.print("choice is c: "+c);
		if(c==1) {
			ps=con.prepareStatement("update t1 set name = ? where name =?");
		}
		else if(c==2) {
			ps=con.prepareStatement("update t1 set password = ? where name =?");
		}
		else{
			ps=con.prepareStatement("update t1 set email = ? where name =?");
		}
		//ps.setString(1,s);
		ps.setString(1,iu.getChange());
		//ps.setString(3,"name");
		ps.setString(2, iu.getName());
		i=ps.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			}
			catch(SQLException e1){
				e1.printStackTrace();
			}
		}
		return i;
		

	}

	@Override
	public int deleteProfileDao(InstaUser iu) {
		// TODO Auto-generated method stub
		int i =0;
		Connection con=null;
		try {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		con=DriverManager.getConnection("jdbc:derby:e:/db2");
		PreparedStatement ps=con.prepareStatement("delete from t1 where email=?");
		ps.setString(1,iu.getEmail() );
		i=ps.executeUpdate();
		}
		catch(ClassNotFoundException|SQLException e1) {
			e1.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return i;
		

	}

	@Override
	/*
	 * public InstaUser searchProfileDao(InstaUser iu) throws Exception { // TODO
	 * Auto-generated method stub System.out.println("profile searched");
	 * Class.forName("org.apache.derby.jdbc.EmbeddedDriver"); //create connection
	 * with db Connection con=DriverManager.getConnection("jdbc:derby:e:/db2");
	 * //create query PreparedStatement
	 * ps=con.prepareStatement("select *from t1 where name=?");
	 * ps.setString(1,iu.getName()); ResultSet res=ps.executeQuery(); InstaUser
	 * iu1=null; while(res.next()) { iu1=new InstaUser();
	 * iu1.setName(res.getString(1)); iu1.setEmail(res.getString(2));
	 * iu1.setPassword(res.getString(3)); } return iu1;
	 * 
	 * }
	 */
	public List<InstaUser> searchProfileDao(InstaUser iu) throws InstaException{
		// TODO Auto-generated method stub
		/*System.out.println("profile searched");*/
		Connection con=null;
		List<InstaUser> ll=null;
		try {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		//create connection with db
		con=DriverManager.getConnection("jdbc:derby:e:/db2");
		//create query
		PreparedStatement ps=con.prepareStatement("select *from t1 where name=?");
		ps.setString(1,iu.getName());
		ResultSet res=ps.executeQuery();
		ll=new ArrayList<InstaUser>();
		
		while(res.next()) {
			InstaUser iu1=new InstaUser();
			iu1.setName(res.getString(1));
			iu1.setEmail(res.getString(3));
			iu1.setPassword(res.getString(2));
			ll.add(iu1);
		}
		//if(ll.size()==0) {
		//	throw new InstaException(" ");
		//}
		if(ll.size()==0) {
			throw new InstaException(" ");
		}
		else if(ll.size()<3) {
			throw new InstaException(" ");
		}
		
	}
		catch(ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			}
			catch( SQLException e1){
				e1.printStackTrace();
			}
		}
		return ll;
		
	}

	@Override
	public String viewAllProfileDao() throws Exception{
	

		File f=new File("e:/hsbc_training/w2/dao.txt");
		FileInputStream in=new FileInputStream(f);
		int c=0;
		///int b=(int)'\n';
		/////System.out.print(b);
		//List<String> ll=new ArrayList<String>();
		String s="";
		while(!((c=in.read())==-1)) {
			//s="";
			
			//while((c=in.read())!=b) {
				
				s+=(char)c;
				//System.out.print("a");
			//}
			//System.out.print("b");
			//ll.add(s);
		}
		//System.out.print("file write method done");
		in.close();
		//for(int i=0;i<)
		return s;
		
		
		
		/*  DERBY CODE
	public List<InstaUser> viewAllProfileDao() throws Exception{
		Connection con=null;
		List<InstaUser> l=null;
		try {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		con=DriverManager.getConnection("jdbc:derby:e:/db2");
		PreparedStatement ps=con.prepareStatement("select * from t1");
		ResultSet res=ps.executeQuery();
		l=new ArrayList<InstaUser>();
		while(res.next()) {
			InstaUser iu1=new InstaUser();
			iu1.setName(res.getString(1));
			iu1.setPassword(res.getString(2));
			iu1.setEmail(res.getString(3));
			l.add(iu1);
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			}
			catch(SQLException e1) {
				e1.printStackTrace();
			}
		}
		return l;*/
		
	}

	@Override
	public Map<String, List<InstaUser>> viewhistorydao() throws Exception {
		// TODO Auto-generated method stub
		Map<String,List<InstaUser>> m=new HashMap<String,List<InstaUser>>();
		// DERBY EFFECT
		//List<InstaUser> l=viewAllProfileDao();
		//List<InstaUser> l1=viewAllProfileDao();
		
		//m.put("studentlist",l);
		//m.put("proflist",l1);
		
		return m;
		
	}

}
