<%-- 
    Document   : market
    Created on : Oct 21, 2018, 12:12:29 AM
    Author     : ARUN VSP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String id = request.getParameter("userId");
String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:derby://localhost:1527/employee ";

String userId = "ben";
String password = "stewart";



try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<h2 align="center"><font color="green"><strong>values</strong></font></h2>

 
<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr>

</tr>
<tr bgcolor="#A52A2A">
<td><b>user</b></td>
<td><b>roll</b></td>
<td><b>email</b></td>
<td><b>password</b></td>

</tr>
<%
try{ 
connection = DriverManager.getConnection(connectionUrl, userId, password);
statement=connection.createStatement();
String sql ="SELECT * FROM SIGNIN";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr bgcolor="#DEB887">

<td><%=resultSet.getString("username") %></td>
<td><%=resultSet.getString("rollno") %></td>
<td><%=resultSet.getString("email") %></td>
<td><%=resultSet.getString("password") %></td>


</tr>

<% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>
</table>

