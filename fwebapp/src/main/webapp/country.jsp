<%@page import="java.util.*,com.fwebapp.Service.Service,com.fwebapp.Service.ServiceInterface,com.fwebapp.Dao.Dao,com.fwebapp.Dao.DaoInterface,com.fwebapp.Utility.ServiceFactory,java.util.ArrayList,java.util.List" %>

<%
ServiceInterface si=ServiceFactory.createObject("admin");
//fbuser fu=new fbuser();
List<String> li=si.getCountries();
%>
<!--  <font color=red >li</font>-->
<%
String ss="<select>";
for(String l:li){
	ss=ss+"<option>"+l+"</option>";
}

ss=ss+"</select>";
out.println(ss);
%>
