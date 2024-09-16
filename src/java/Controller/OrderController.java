/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Entity.Account;
import Entity.OrderItems;
import Entity.Orderr;
import Entity.Products;
import Model.DAOOrderItems;
import Model.DAOOrderr;
import Model.DAOProducts;
import Model.DaoAccount;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.jsp.jstl.sql.Result;
import java.util.Vector;

/**
 *
 * @author user
 */
public class OrderController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        DaoAccount account = new DaoAccount();

        DAOProducts daoProduct = new DAOProducts();

        DAOOrderr dao = new DAOOrderr();

        DAOOrderItems Daoitems = new DAOOrderItems();

        String service = request.getParameter("service");
        if (service == null) {
            service = "listBill";
        }

        if (service.equals("listBill")) {
            String submit = request.getParameter("submit");
            if (submit == null) {
                String sql = "select o.OrderID, c.Fullname, o.OrderDate, Sum(o1.price) as total,o.Statuss from Orderr as o join Account as c on o.AccountID = c.AccountID \n"
                        + "join OrderItems as o1 on o.OrderID = o1.OrderID\n"
                        + "group by o.OrderID, c.Fullname,o.OrderDate,o.Statuss";
                ResultSet rsOrder = dao.getData(sql);
                request.setAttribute("rsOrder", rsOrder);

                 
                ResultSet rsCountOrder = dao.getData("select COUNT(OrderID) from Orderr");
                 request.setAttribute("rsCountOrder", rsCountOrder);
                 
                 ResultSet rsTotalOrder = dao.getData("select SUM(price) from OrderItems");
                 request.setAttribute("rsTotalOrder", rsTotalOrder);
                
                request.getRequestDispatcher("Billmanager.jsp").forward(request, response);
            }
        }

        if (service.equals("orderdetail")) {
            int OrderID = Integer.parseInt(request.getParameter("OrderID"));
            String sql = "select o.ItemsID, p.productName, o.quantity, o.price, o.OrderID from OrderItems as o \n"
                    + "join Products as p on o.ProductID = p.productID\n"
                    + "where o.OrderID = " + OrderID;
            ResultSet rsItems = dao.getData(sql);
            request.setAttribute("rsItems", rsItems);
            request.getRequestDispatcher("viewOrderDetails.jsp").forward(request, response);
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
