package com.fwebapp.insta.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fwebapp.insta.Entity.InstaUser;
import com.fwebapp.insta.Service.InstaService;
import com.fwebapp.insta.Service.InstaServiceInterface;

/**
 * Servlet implementation class SigninInstaServlet
 */
public class SigninInstaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InstaServiceInterface is=new InstaService();
		InstaUser iu=new InstaUser();
		String password=request.getParameter("password");
		iu.setPassword(password);
		String name=request.getParameter("name");
		iu.setName(name);
		String email=request.getParameter("email");
		iu.setEmail(email);
		
		int i=0;
		try {
			i = is.createProfile(iu);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i>0) {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.println("<html><body>");
			if(i>0) {
				out.println("registration successful<a href=insta_login.html>Continue?</a>");
				out.println("<br> name is: "+name);
				out.println("<br> password is: "+password);
				out.println("</body></html>");
				
			}
			else {
				out.println("could not create profile");
				out.println("</body></html>");
			}
		}
		
	}

}
