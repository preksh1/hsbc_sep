package com.fwebapp.insta.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fwebapp.insta.Entity.InstaUser;
import com.fwebapp.insta.Service.InstaService;
import com.fwebapp.insta.Service.InstaServiceInterface;

/**
 * Servlet implementation class loginServlet
 */
public class loginServlet extends HttpServlet {
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			
			
			String name=request.getParameter("name");
			String password=request.getParameter("password");
			
			InstaUser iu=new InstaUser();
			iu.setName(name);
			iu.setPassword(password);
			
			InstaServiceInterface is=new InstaService();
			boolean i=false;
			try {
				i = is.loginProfile(iu);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.println("<html><body>");
			if(i) {
				
				HttpSession ss=request.getSession(true);
				ss.setAttribute("name", name);
				ss.setAttribute("password", password);
				out.println("hey welcome "+name+"<a href=timeline>Timeline</a><a href=friendlist>friendlist</a>");
				
			}
			else {
				out.println("it is an invalid id and password");
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/insta_login.html");
				rd.include(request,response);
			}
		out.println("</body></html>");
		
		
	}

}
