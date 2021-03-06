/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Corser_TOBA;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author AURYN
 */
@WebServlet(name = "ResetPassword", urlPatterns = {"/ResetPassword"})
public class ResetPassword extends HttpServlet {
 
    
    
    
    
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
            out.println("<title>Servlet ResetPassword</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ResetPassword at " + request.getContextPath() + "</h1>");
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        processRequest(request, response);
        
      
           String OldPassword =  request.getParameter("current");
           String NewPassword =  request.getParameter("new");
           String ConfirmPassword =  request.getParameter("confirm");
         
           HttpSession session = request.getSession();
           String FinalPassword=(String)session.getAttribute("Final");
         
           
           
           if (OldPassword == null || NewPassword == null || ConfirmPassword == null || OldPassword.isEmpty() || NewPassword.isEmpty() || ConfirmPassword.isEmpty()) {
            
               request.setAttribute("message", "All fields are required.");
               getServletContext().getRequestDispatcher("Reset_Password.jsp").forward(request, response);
               
           }
           else if (!NewPassword.equals(ConfirmPassword)) {
    
               request.setAttribute("message", "Passwords do not match.");
               getServletContext().getRequestDispatcher("Reset_Password.jsp").forward(request, response);
               
           }
        
           else if (FinalPassword.equals(OldPassword)) {
    
               request.setAttribute("message", "You can not use your old password if you're attempting to create a new one.");
               getServletContext().getRequestDispatcher("Reset_Password.jsp").forward(request, response);
               
           }
        
           else {
                              
               request.setAttribute("message", "Password changed successfully!");
               getServletContext().getRequestDispatcher("Success.jsp").forward(request, response);
               
        
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
