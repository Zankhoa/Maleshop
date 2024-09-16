/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Entity.Account;
import Model.DaoAccount;
import com.oracle.wls.shaded.org.apache.bcel.generic.AALOAD;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Vector;

/**
 *
 * @author user
 */
public class loginController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       HttpSession session = request.getSession(true);
        DaoAccount dao = new DaoAccount();
        String service = request.getParameter("service");
         
        if(service.equals("logout")){
             session.invalidate();
             response.sendRedirect("loginAccount.jsp");
         }
        
        if(service.equals("login")){    
            String submit = request.getParameter("submit");
            if(submit == null){
                request.getRequestDispatcher("loginAccount.jsp").forward(request, response);
            }
             String userName = request.getParameter("userName");
            String passWord = request.getParameter("passWord");
           Account ngu = dao.loginAccount(userName, passWord);
            if(ngu != null){
                session.setAttribute("acc", ngu);
                response.sendRedirect("homee");
            } else {
                String message = "the account username or password wrong";
                request.setAttribute("message", message);
                 request.getRequestDispatcher("loginAccount.jsp").forward(request, response);
            }
        }
        
        if(service.equals("register")){
            String submit = request.getParameter("submit");
            if(submit == null){
                request.getRequestDispatcher("register.jsp").forward(request, response);
            } else {
               int isAdmin = 1; 
               String userName = request.getParameter("userName"); 
               String passWord = request.getParameter("passWord"); 
               String fullname = request.getParameter("fullname"); 
               String phone = request.getParameter("phone"); 
               String email = request.getParameter("email");
               
               Account acc = new Account(isAdmin, userName, passWord, fullname, phone, email);
               int n = dao.insert(acc);
               response.sendRedirect("loginAccount.jsp");
               
            }
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
