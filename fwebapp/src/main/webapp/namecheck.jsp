<%@page import="java.io.IOException,java.io.PrintWriter,javax.servlet.ServletException,javax.servlet.http.HttpServlet,javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse,com.fwebapp.Entity.fbuser,com.fwebapp.Service.ServiceInterface,com.fwebapp.Utility.ServiceFactory"%>



<%

		ServiceInterface si = null;
		try {
			si = ServiceFactory.createObject("admin");
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		
		fbuser fu=new fbuser();
		String name=request.getParameter("name");
		
		
		
		
		
		fu.setName(name);
		
			
			boolean i=si.checkProfile(fu);
			if(i) { %>
				
			<font color=red>INVALID USER</font>
			
		<%}
			else{%>
			<font color=green>VALID USER</font>
		
		<%}
		
		%>
			
