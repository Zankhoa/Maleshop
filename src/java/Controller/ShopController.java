/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Entity.Brand;
import Entity.Category;
import Entity.Products;
import Model.DAOShop;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.oracle.wls.shaded.org.apache.bcel.generic.AALOAD;
import java.util.Vector;

/**
 *
 * @author user
 */
public class ShopController extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        DAOShop dao = new DAOShop();  
        
        String service = request.getParameter("service");
        if (service == null) {
            service = "listProducts";
        }
        
        
        
        if(service.equals("listProducts")){
            String submit = request.getParameter("submit");
             Vector<Products> proo;
            if(submit == null){
                proo = dao.listProducts("select * from products");               
            } else { 
        String name = request.getParameter("name");
           proo = dao.listProducts("select * from products where productName like '%" + name + "%'");
            }
             request.setAttribute("proo", proo);
              Vector<Brand> listB = dao.listBrand("select * from brand");
                Vector<Category> listC = dao.listCategory("select * from category");
       
        request.setAttribute("listB", listB);
        request.setAttribute("listC", listC);
        request.getRequestDispatcher("Shop.jsp").forward(request, response);
        }

//                Vector<Brand> listB = dao.listBrand("select * from brand");
//                Vector<Category> listC = dao.listCategory("select * from category");
//       
//        request.setAttribute("listB", listB);
//        request.setAttribute("listC", listC);
//        request.getRequestDispatcher("Shop.jsp").forward(request, response);
        
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