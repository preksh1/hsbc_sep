package com.fwebapp.controller;
//import com.insta_java.service.InstaService;
<%@page import="java.io.IOException,java.io.PrintWriter,javax.servlet.ServletException,javax.servlet.http.HttpServlet,javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse,com.fwebapp.Entity.fbuser,com.fwebapp.Service.ServiceInterface,com.fwebapp.Utility.ServiceFactory"%>
<%--hey --%>


<%

		ServiceInterface si = null;
		try {
			si = ServiceFactory.createObject("admin");
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//ServiceInterface si=null;
		//protected RegistrationServlet() {
			
		//	si=ServiceFactory.createObject("admin");
			
	//	}
		fbuser fu=new fbuser();
		String password=request.getParameter("password");
		fu.setPassword(password);
		String name=request.getParameter("name");
		
		
		
		
		
		fu.setName(name);
		String email=request.getParameter("email");
		fu.setEmail(email);
		
			
			int i=si.createProfile(fu);
			if(i>0) { %>
				
			registration successful <a href=login.html>Continue?</a>
			your name is <%= name%>
			<br>your password is <%= password %>
			
		<%	} %>
			
