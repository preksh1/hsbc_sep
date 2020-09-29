package com.fwebapp.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fwebapp.Entity.fbuser;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

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
	@Override
	public boolean checkProfile(fbuser fu) throws Exception {
		// TODO Auto-generated method stub
		boolean i=false;
		PreparedStatement ps=con.prepareStatement("select * from fb where name=?");
		ps.setString(1, fu.getName());
		ResultSet res=ps.executeQuery();
		if(res.next()){
			i=true;
		}
		return i;
	}
	@Override
	public List<String> getCountriesDao() throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement ps=con.prepareStatement("select name from Countries");
		ResultSet res=ps.executeQuery();
		List<String> ll=new ArrayList<String>();
		while(res.next()) {
			ll.add(res.getString(1));
			
		}
		return ll;
		
	}
	@Override
	public List<String> getStationDao(fbuser fu) throws Exception {
		
		//taking station in name
		
		String stati=fu.getName();
		System.out.println(stati);
		//PreparedStatement ps=con.prepareStatement("select name from Station where name like ? ESCAPE '!'");
		//station = station.replace("!", "!!").replace("%", "!%").replace("_", "!_").replace("[", "![");
		PreparedStatement ps=con.prepareStatement("select name from Station where name like ?");
		System.out.println(stati);
		ps.setString(1, stati + "%");
		System.out.println(ps);
		ResultSet res=ps.executeQuery();
		System.out.println(res);
		List<String> ll=new ArrayList<String>();
		//System.out.println(stati);
		
		while(res.next()) {
			ll.add(res.getString(1));
		}
		System.out.println(ll);
		return ll;
	}
	
	
	

}
