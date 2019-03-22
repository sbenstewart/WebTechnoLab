/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sf52
 */
@WebServlet(name = "success", urlPatterns = {"/success"})
public class success extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
String sql="insert into signin values(a,b,c,d)";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String drivername="com.mysql.jdbc.Driver";
    String url="jdbc:derby://localhost:1527/employee ";
    String userid="arun";
    String password="arun";
    Connection connection=null;
    Statement statement=null;
    ResultSet resultset=null;
    try{
Class.forName(drivername);
}
catch(ClassNotFoundException e)
{
e.printStackTrace();
}
        try {
            PrintWriter out = response.getWriter();
            Object m=request.getParameter("uname");
    Object n=request.getParameter("roll");
     Object o=request.getParameter("email");
     Object p=request.getParameter("pass");
     String a=(String)m;
     String b=(String)n;
    String c=(String)o;
    String d=(String)p; 

    connection = DriverManager.getConnection(url, userid, password);
//statement=connection.createStatement();
 PreparedStatement pst=connection.prepareStatement("insert into signin values('"+a+"','"+b+"','"+c+"','"+d+"')");
        int i=pst.executeUpdate();
            

       
       
      RequestDispatcher rd=request.getRequestDispatcher("signedin.html");
                  rd.forward(request,response);
        
        }
        
        catch(Exception e)
        {
        System.out.println(e);
        }
    /* TODO output your page here. You may use following sample code. */
          
    }
        
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
