package com.fwebapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fwebapp.Entity.fbuser;
import com.fwebapp.Service.ServiceInterface;
import com.fwebapp.Utility.ServiceFactory;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		
		fbuser fu=new fbuser();
		fu.setName(name);
		fu.setPassword(password);
		
		ServiceInterface si = null;
		try {
			si = ServiceFactory.createObject("admin");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		boolean i=false;
		try {
			i = si.loginProfile(fu);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		
		if(i) {
			HttpSession ss=request.getSession(true);
			ss.setAttribute("userid", name);
			ss.setAttribute("pass", password);
			out.println("welcome "+name+" <a href=Timeline>timeline</a> <a href=FrienList>friendlist</a>");
		}
		else {
			out.println("invalid id and password");
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/login.html");
			rd.include(request,response);
			
		}
		out.println("</body></html>");
		
		
		
		
		
	}

}
