package com.fwebapp.insta.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fwebapp.insta.Entity.InstaUser;

public class InstaDao implements InstaDaoInterface {

	@Override
	public int createProfileDao(InstaUser iu) throws Exception {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		Connection con=DriverManager.getConnection("jdbc:derby:e:/db2");
		PreparedStatement ps=con.prepareStatement("insert into t1 values(?,?,?)");
		ps.setString(1, iu.getName());
		ps.setString(2, iu.getPassword());
		ps.setString(3, iu.getEmail());
		int i=ps.executeUpdate();
		return i;
	}

	@Override
	public boolean loginProfileDao(InstaUser iu) throws Exception {
		
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		Connection con=DriverManager.getConnection("jdbc:derby:e:/db2");
		PreparedStatement ps=con.prepareStatement("select * from t1 where name=? and password=?");
		ps.setString(1, iu.getName());
		ps.setString(2, iu.getPassword());
		boolean i=false;
		ResultSet res=ps.executeQuery();
		if(res.next()) {
			i=true;
		}
		
		return i;
	}

	
}
