/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sf52
 */
@WebServlet(urlPatterns = {"/FileUploadDBServlet"})
public class FileUploadDBServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private String dbURL="jdbc:mysql://localhost:3306/servlet";
    private String dbUser="root";
    private String dbPass="";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FileUploadDBServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FileUploadDBServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        String firstName=request.getParameter("firstName");
        String lastName=request.getParameter("lastName");
        String Number=request.getParameter("Number");
        Connection conn=null;
        String message=null;
        try
        {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn=DriverManager.getConnection(dbURL,dbUser,dbPass);
            System.out.println(firstName);
            String sql="INSERT INTO employee (firstName,lastName,Number) values(?,?,?)";
            PreparedStatement stmt=conn.prepareStatement(sql);
            stmt.setString(1,firstName);
            stmt.setString(2,lastName);
            stmt.setString(3,Number);
            int row=stmt.executeUpdate();
            if(row>0)
                message = "Data loaded into database";
        }catch(Exception e)
        {
            message = "ERROR: "+e.getMessage();
            e.printStackTrace();
        }finally
        {
            if(conn!=null)
            {
                try{
                    conn.close();
                }catch(SQLException e)
                {
                    e.printStackTrace();
                }
            }
            request.setAttribute("Message",message);
            getServletContext().getRequestDispatcher("/Message.jsp").forward(request, response);
        }
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
