<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page import="java.util.*" %>
    
    <%
   	 String user = (String)session.getAttribute("user");
    	if(user == null)
    		response.sendRedirect("index.jsp");
    	String name = request.getParameter("name");
    	String gender = request.getParameter("gender");
    	String org = request.getParameter("org");
    	//int salary = Integer.parseInt(request.getParameter("income"));
    	double salary = Double.parseDouble(request.getParameter("income"));
    	double tax = 0.0;
    	double percent = 0.0;
    	if(salary >= 0 && salary <= 100000)
    		percent = 0.0;
    	else if(salary > 100000 && salary <= 500000 )
    		percent = 15.0;
    	else
    		percent = 20.0;
    	tax = (salary*percent/100);
    	session.setAttribute("name", name);
    	session.setAttribute("org", org);
    	session.setAttribute("gender", gender);
    	session.setAttribute("salary", salary);
    	session.setAttribute("tax", tax);
    	session.setAttribute("percent", percent);
    	response.sendRedirect("dataCapture.jsp");
    	
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tax</title>
</head>
<body>

</body>
</html>