<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
    
    <%
    	Date date = new Date();
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tax Details</title>
</head>

<body>
	<h2> Welcome <%= session.getAttribute("user") %></h2>
	<div> Date : <%=date.toString() %></div>
	
	<form action="CalculateTax.jsp">
		<label>Name : <input type="text" name="name"/> </label><br/>
		<label> Gender : Male <input type="radio" name="gender"value="male"/> Female <input type="radio" name="gender"value="female"/></label><br/>
		<label>Organization Name : </label>
		<select name ="org">
			<option value="goog">  Google </option>
			<option value="msft"> Microsoft </option>
			<option value="in"> Linkedin </option>
		</select><br/>
		
		<label>Income : <input type="income" name="income"/></label><br/>
		<input type="submit" name="submit"/>
	</form>
	
	<%
	 	if(session.getAttribute("name") != null)
	 	{
	 		String name = (String)session.getAttribute("name");
	 		String gender = (String)session.getAttribute("gender");
			String org = (String)session.getAttribute("org");
			double salary = (Double)session.getAttribute("salary");
			double incomeTax = (Double)session.getAttribute("tax");
			double percent = (Double)session.getAttribute("percent");
		
	 %>
	 	
	 <div>
	 	NAme : <%=name %> <br/>
	 	Gender : <%=gender %><br/>
 		Organization: <%=org %><br/>
		Salary: <%=salary %><br/>
		Income Tax: <%=incomeTax %><br/>
		percent: <%=percent %><br/>
	 	</div>

	 	
	 	
	 <%} %>
	 
	 <a href="index.jsp?status=2">Logout</a>
</body>
</html>