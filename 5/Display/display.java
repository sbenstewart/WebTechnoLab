import java.io.*;
 import javax.servlet.*;
 import javax.servlet.http.*;
 import java.sql.*;

 public class display extends HttpServlet {

     public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
         PrintWriter out = res.getWriter();
         res.setContentType("text/html");
         out.println("<html><body>");
         try {
             Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
             Connection con = DriverManager.getConnection("jdbc:odbc:mydsn", "system", "pintu");
             // Here dsnname- mydsn,user id- system(for oracle 10g),password is pintu.
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from employee");
             out.println("<table border=1 width=50% height=50%>");
             out.println("<tr><th>EmpId</th><th>EmpName</th><th>Salary</th></tr>");
             while (rs.next()) {
                 String n = rs.getString("empid");
                 String nm = rs.getString("empname");
                 int s = rs.getInt("sal");
                 out.println("<tr><td>" + n + "</td><td>" + nm + "</td><td>" + s + "</td></tr>");
             }
             out.println("</table>");
             out.println("</html></body>");
             con.close();
            }
             catch (Exception e) {
             out.println("error");
         }
     }
 }
