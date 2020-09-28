package com.fwebapp.controller;
//import com.insta_java.service.InstaService;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fwebapp.Entity.fbuser;
import com.fwebapp.Service.ServiceInterface;
import com.fwebapp.Utility.ServiceFactory;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		
		
		try {
			
			int i=si.createProfile(fu);
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.println("<html><body>");
			if(i>0) {
				
				out.println("registration successful <a href=login.html>Continue?</a>");
				out.println("<br>name is "+name);
				out.println("<br>password is "+password);
				
				out.println("</body></html>");
			}
			else {
				//out.println("<html><body>");
				
				out.println("<br>could not add to database");
				out.println("</body></html>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
	}

}
