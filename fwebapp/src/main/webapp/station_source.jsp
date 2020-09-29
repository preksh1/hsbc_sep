<%@page import="java.util.*,com.fwebapp.Service.Service,com.fwebapp.Service.ServiceInterface,com.fwebapp.Dao.Dao,com.fwebapp.Dao.DaoInterface,com.fwebapp.Utility.ServiceFactory,com.fwebapp.Entity.fbuser,java.util.ArrayList,java.util.List" %>
<%

String x=request.getParameter("station");
ServiceInterface si=ServiceFactory.createObject("admin");
fbuser fu=new fbuser();
fu.setName(x);
List<String> ll=si.getStation(fu);

String ss="<select>";
//String ss="<datalist>";
//String ss="";
for(String l:ll){
	ss=ss+"<option>"+l+"</option>";
	//ss=ss+"<option value= "+l+">";
	
}
//ss+="</datalist>";
ss+="</select>";
//out.println(ll);
out.println(ss);




%>
