<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
  <%@ page import="java.sql.*" %>
 <%
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/Java";
	String user = "root";
	String password = "root";
	Connection con = null;
 	try{
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, password);
	}
	catch (Exception e) {
		e.printStackTrace();
		
	}
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ordered T-shirts</title>
</head>
<body>
	<%
		Statement statement = con.createStatement();
		String query = "select * from tshirt";
		ResultSet rs = statement.executeQuery(query);
	%>
	<table border="1">
		<thead>
			<td>Order num</td>
			<td>Color</td>
			<td>Chest pocket</td>
			<td>Tagline</td>
			<td>Accessories</td>
		</thead>
		<tbody>
			<% while(rs.next()) { %>
			<tr>
			<td align="center"><%= rs.getInt("orderNo") %></td>
			<td><%= rs.getString("color") %></td>
			<td>
			<% if (rs.getInt("chestPocket")== 1)
					out.print("yes");
				else
					out.print("no");%>
			</td>
			<td><%=rs.getString("tagline") %></td>
			<td><%= rs.getString("accessories") %></td>
			</tr>
			<% } %>
		</tbody>
	</table>

</body>
</html>