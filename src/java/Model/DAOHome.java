/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Entity.Products;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DAOHome extends DBConnect{

    public Vector<Products> newArrival(String sql){
        Vector<Products> vector = new Vector<Products>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
           ResultSet rs = state.executeQuery(sql);
           while(rs.next()) {
             int productID = rs.getInt(1);
            String productName = rs.getString(2);
            int yearofproducts = rs.getInt(3);
            String img = rs.getString(4);
            double price = rs.getDouble(5);
            String describe = rs.getString(6);
            int quantity = rs.getInt(7);
            int categoryID = rs.getInt(8);
            int brandID = rs.getInt(9);
            
            Products pro = new Products(productID, productName, yearofproducts, img, price, describe, quantity, categoryID, brandID);
            vector.add(pro);
           }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
       return vector;
    }
    
    
}
