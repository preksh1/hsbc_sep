package com.fwebapp.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.fwebapp.Entity.fbuser;

public class Dao implements DaoInterface {

	Connection con=null;
	public Dao() throws Exception {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		con=DriverManager.getConnection("jdbc:derby:e:/db2");
	}
	public int createProfileDao(fbuser fu) throws Exception {
		//Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
//		Connection con=DriverManager.getConnection("jdbc:derby:e:/db2");
		PreparedStatement ps=con.prepareStatement("insert into fb values(?,?,?)");
		ps.setString(1, fu.getName());
		ps.setString(2, fu.getPassword());
		ps.setString(3, fu.getEmail());
		int i=ps.executeUpdate();
		//System.out.println("updated "+i);
		return i;
	}

	public int deleteProfileDao(fbuser fu) {
	/*	Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		Connection con=DriverManager.getConnection("jdbc:derby:e:/db2");
		PreparedStatement ps=con.prepareStatement("delete from fb where name=?");
		ps.setString(1, fu.getName());
		ps.setString(2, fu.getPassword());
		ps.setString(3, fu.getEmail());
		int i=ps.executeUpdate();
		//System.out.println("updated "+i);
		return i;*/
		return 0;
	}

	public fbuser viewProfileDao(fbuser fu) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<fbuser> viewAllProfileDao() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean loginProfile(fbuser fu) throws Exception {
		boolean i=false;
		try {
			//Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			//Connection con=DriverManager.getConnection("jdbc:derby:e:/db2");
			PreparedStatement ps=con.prepareStatement("select * from fb where name=? and password=?");
			ps.setString(1,fu.getName());
			ps.setString(2, fu.getPassword());

			ResultSet res=ps.executeQuery();
			if(res.next()) {
				i=true;
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return i;
	}
	
	
	

}
