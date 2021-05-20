/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.UserLogin;
import models.dto.UserData;
import services.UserLoginService;

/**
 *
 * @author John
 */
@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servlet2 at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servlet2 at " + request.getContextPath() + "</h1>");
            out.println("<form name=\"login\" action=\"login\" method='POST'>\n" +
"            <input type=\"text\" name=\"username\" value=\"\" size=\"25\" />\n" +
"            <input type=\"password\" name=\"password\" value=\"\" />\n" +
"            <input type=\"submit\" value=\"Login\" name=\"submit\" />\n" +
"            </form>");
            out.println("</body>");
            out.println("</html>");
        }
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
        RequestDispatcher rd;
        UserLogin ul = new UserLogin();
        UserLoginService ulService = new UserLoginService();
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servlet2 at " + request.getContextPath() + "</h1>");
            out.println("Well done you've made it!");
            out.println("<p>" + request.getMethod() + "</p>");
            ul.setUsername(request.getParameter("username"));
            ul.setPassword(request.getParameter("password"));
//            
            UserData userData  = ulService.validateLogin(ul);
            // redirect the request to a secure page!!!!!!!
            if (userData != null) {
                
                
                
                // 2nd /login, method = POST (1st /login is the method = GET)
                // correct credentials
                request.setAttribute("user", userData);
                rd = request.getRequestDispatcher("/WEB-INF/views/secure.jsp");
                rd.forward(request, response);               
            } else {
                // 2nd /login, method = POST (1st /login is the method = GET)
                // wrong credentials SOOOOOOOO
                
                // CREATE A NEW REQUEST with EMPTY data and REDIRECT to /login method = GET
                // this is the 3rd /login (GET)
                response.sendRedirect("login"); // NEW REQUEST "login" <---- /login GET
            }
            
            
//            out.println("<p>Username = " + ul.getUsername() + "</p>");
//            out.println("<p>Password = " + ul.getPassword() + "</p>");
            out.println("<p>Validation = " + userData + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) {
        
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
