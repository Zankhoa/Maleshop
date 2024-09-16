/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Entity.Brand;
import Entity.Category;
import Entity.Products;
import Model.DAOMangerProducts;
import Model.DAOShop;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Vector;

public class ManagerProducts extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        DAOMangerProducts dao = new DAOMangerProducts();

        DAOShop daoShop = new DAOShop();

        String service = request.getParameter("service");
        if (service == null) {
            service = "listProduct";
        }

        if (service.equals("listProduct")) {
            String submit = request.getParameter("submit");
            Vector<Products> managerProducts;
            if (submit == null) {
                managerProducts = dao.listProducts("select * from products");
            } else {
                String name = request.getParameter("name");
                managerProducts = dao.listProducts("select * from products where productName like '%" + name + "%'");
            }
            request.setAttribute("managerProducts", managerProducts);

            Vector<Brand> listB = daoShop.listBrand("select * from Brand");
            request.setAttribute("listB", listB);
            Vector<Category> listC = daoShop.listCategory("select * from category");
            request.setAttribute("listC", listC);

            RequestDispatcher dispth = request.getRequestDispatcher("ManagerShop.jsp");
            dispth.forward(request, response);
        }

        if (service.equals("insert")) {
            String submit = request.getParameter("submit");
            if (submit == null) {
                RequestDispatcher dispth = request.getRequestDispatcher("ManagerShop.jsp");
                dispth.forward(request, response);
            } else {
                String productName = request.getParameter("productName");
                int yearofproducts = Integer.parseInt(request.getParameter("yearofproducts"));
                String img = request.getParameter("img");
                double price = Double.parseDouble(request.getParameter("price"));
                String describe = request.getParameter("describe");
                int quantity = Integer.parseInt(request.getParameter("quantity"));
                int categoryID = Integer.parseInt(request.getParameter("categoryID"));
                int brandID = Integer.parseInt(request.getParameter("brandID"));

                Products product = new Products(productName, yearofproducts, img, price, describe, quantity, categoryID, brandID);
                int n = dao.insert(product);
                response.sendRedirect("URLManagerProducts");
            }
        }

        if (service.equals("update")) {
            String submit = request.getParameter("submit");
            
            if (submit == null) {
              int productId = Integer.parseInt(request.getParameter("productId"));  

                Vector<Products> managerProducts = dao.listProducts("select * from products where productID = " + productId);
               
                request.setAttribute("managerProducts", managerProducts);
                
                Vector<Brand> listB = daoShop.listBrand("select * from Brand");
                request.setAttribute("listB", listB);

                Vector<Category> listC = daoShop.listCategory("select * from category");
                request.setAttribute("listC", listC);

                RequestDispatcher dispth = request.getRequestDispatcher("updatedemo.jsp");
                dispth.forward(request, response);
            } else {
                int prdoductID = Integer.parseInt(request.getParameter("prdoductID"));
                String productName = request.getParameter("productName");
                int yearofproducts = Integer.parseInt(request.getParameter("yearofproducts"));
                String img = request.getParameter("img");
                double price = Double.parseDouble(request.getParameter("price"));
                String describe = request.getParameter("describe");
                int quantity = Integer.parseInt(request.getParameter("quantity"));
                int categoryID = Integer.parseInt(request.getParameter("categoryID"));
                int brandID = Integer.parseInt(request.getParameter("brandID"));

                Products product = new Products( prdoductID, productName, yearofproducts, img, price, describe, quantity, categoryID, brandID);
                int n = dao.update(product);
                response.sendRedirect("URLManagerProducts");
            }
        }
        
        if(service.equals("delete")){
           int prdoductID = Integer.parseInt(request.getParameter("prdoductID"));
           int n = dao.delete(prdoductID);
            response.sendRedirect("URLManagerProducts");
              
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
