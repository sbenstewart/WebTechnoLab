/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.*;

/**
 *
 * @author sf52
 */
@WebServlet(urlPatterns = {"/SessionTrack"})
public class SessionTrack extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession(true);
        Date createTime=new Date(session.getCreationTime());
        Date lastAccessTime=new Date(session.getLastAccessedTime());
        String title="Welcome back";
        Integer visitCount = new Integer(0);
        String visitCountKey=new String("Visit Count");
        String userIDKey=new String("User ID");
        String userID=new String("ABCD");
        if(session.isNew())
        {
            title="Welcome to my website";
            session.setAttribute(userIDKey,userID);
        }
        else
        {
            visitCount=(Integer)session.getAttribute(visitCountKey);
            visitCount++;
            userID=(String)session.getAttribute(userIDKey);
        }
        session.setAttribute(visitCountKey, visitCount);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>"+title+"</title>");            
            out.println("</head>");
            out.println("<body bgcolor=#f0f0f0>");
            out.println("<h1 align=\"center\">"+title+ "</h1>");
            out.println("<h1 align=\"center\">SessionInfo</h1>");
            out.println("<table border=\"1\" align=\"center\">");
            out.println("<tr bgcolor=\"949494\"><th>Session Info</th><th>Values</th></tr><tr><td>id</td><td>"+session.getId()+"</td>");
            out.println("<tr><td>Creation Time</td><td>"+createTime+"</td>");
            out.println("<tr><td>Last Access Time</td><td>"+lastAccessTime+"</td>");
            out.println("<tr><td>User ID</td><td>"+userID+"</td>");
            out.println("<tr><td>Number of visits</td><td>"+visitCount+"</td></tr></table>");
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
