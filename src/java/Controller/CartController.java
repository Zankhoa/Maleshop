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
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;

/**
 *
 * @author user
 */
public class CartController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        DAOProducts dao = new DAOProducts();
       
        DAOOrderr daoOrder = new DAOOrderr();
        
        DAOOrderItems daoItems = new DAOOrderItems();
        
        DaoAccount daoAccount = new DaoAccount();
        
        HttpSession session = request.getSession(true);
      
        Account acc = (Account) session.getAttribute("acc");
        
      
    
        
        
        String service = request.getParameter("service");
       if(service == null ){
           service = "listCart";
       }
       
 
       if(service.equals("checkout")){
        Vector<Products> vector = dao.getProducts("select * from products");
           int pid = vector.get(0).getProductID();
           int quantityAvaiable = vector.get(0).getQuantity();
        
           String submit = request.getParameter("submit");
           if(submit == null){
               request.getRequestDispatcher("checkout.jsp").forward(request, response);
           } else {
               int OrderID = daoOrder.getMaxId() + 1;
               
               int AccountID = acc.getAcountID();
                         
              String status = "waiting";
               
              SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
               String OrderDate = sdf.format(new Date());
              
               daoOrder.insertOrder(new Orderr(OrderID, OrderDate, status, AccountID));
                 
               Enumeration enu = session.getAttributeNames();
               int itemID = 1;
               while(enu.hasMoreElements()){
                   String poductid = (String) enu.nextElement();
                    Products product;
                    if (!poductid.equals("acc")) {
                        product = (Products) session.getAttribute(poductid);
                        int n = daoItems.insertItems(new OrderItems(itemID, product.getQuantity(), OrderID , product.getProductID(), product.getPrice()*product.getQuantity()));
                        session.removeAttribute("poductid");
                        itemID++;        
            if(quantityAvaiable >= product.getQuantity() ){
                dao.updateQuantity(product.getProductID(), product.getQuantity());
            } 
                    } 
           }
              
          response.sendRedirect("homee");
       }
       }

       
       
       if(service.equals("deleteCart")){
           String pid = request.getParameter("pid");
           session.removeAttribute(pid);
           response.sendRedirect("Cart");
       }
       if(service.equals("removeAll")){
           Enumeration enu = session.getAttributeNames();
           while(enu.hasMoreElements()){
               String pid = (String)enu.nextElement();
               if(!pid.equals("acc")){
                   session.removeAttribute(pid);
               }
           }
           response.sendRedirect("Cart");
       }
       
       
       
       if(service.equals("AddToCart")){
           int productID = Integer.parseInt(request.getParameter("productID"));
           Products products;
           products = (Products)session.getAttribute(productID + "");
       
           int quantity = Integer.parseInt(request.getParameter("quantity"));
            
           
           if(quantity < 1){
               quantity = 1;
           }    
          
           int quantityOld = dao.listProductsByPid(productID).getQuantity();
           if(quantity > quantityOld){ 
              
               String mess = "The only max quantity have " + quantityOld;
               request.setAttribute("mess", mess);
               request.getRequestDispatcher("productsDetails?productID="+productID ).forward(request, response);
               
           } else {
               if(products == null){
                Products p = dao.getProducts("Select * from products where productID = " + productID).get(0);
                products = new Products(productID, p.getProductName(), p.getImg(), p.getPrice(), quantity);
                session.setAttribute(productID + "", products);
                } else {
                   products.setQuantity(products.getQuantity() + quantity);
                   session.setAttribute(productID+"", products);
               }  
               response.sendRedirect("Cart");   
       }
        }
    if(service.equals("listCart")){
        request.getRequestDispatcher("Cart.jsp").forward(request, response);
    }

    }
    
    


    
    
    
    

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
