<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.util.*" %>
    <%!
    	String status ;
    	HashMap<String, String> users;
    %>
    
    <%
    	status = request.getParameter("status");
    	users = new HashMap<>();
    	users.put("root", "root");
    	users.put("amisha", "1234");
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
	<div>
	<% if (status != null)
	{
		if (status.equals("2"))
		{
			session.invalidate();
		}
		else
		{
			String user = request.getParameter("name");
			String password = request.getParameter("password");
			
			if(!users.containsKey(user)){
	%>
	user doesnt exist 
	<%} else if(users.containsKey(user))
		{
			if(!users.get(user).equals(password))
			{
	%>
	Incorrect password
	<% } else if(users.get(user).equals(password))
		{
			session.setAttribute("user" , user);
			response.sendRedirect("dataCapture.jsp");
		}
		%>
	<%} }} else { %>
	enter username and pass
	<% } %>
	</div>
	<div> <%@ include file="login.html" %> </div>
	
</head>
<body>

</body>
</html>