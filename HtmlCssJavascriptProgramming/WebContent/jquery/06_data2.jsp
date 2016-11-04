<%@ page contentType="text/html; charset=UTF-8"%>

<%
boolean result = true;
String mid = request.getParameter("mid");
if(mid.equals("user1")) {
	result = false;
}
%>

<%=result%>