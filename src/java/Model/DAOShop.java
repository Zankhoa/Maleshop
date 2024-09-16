
package Model;

import Entity.Brand;
import Entity.Category;
import Entity.Products;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOShop extends DBConnect{

    public Vector<Products> listProductByBrand(String BrandID){
        Vector<Products> listBrand = new Vector<Products>();
        String sql = "select * from products where brandID = ?";
        try {
             PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, BrandID);
             ResultSet rs = pre.executeQuery();
            while(rs.next()){
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
            listBrand.add(pro);
            }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        return listBrand;
    }
    
    
    public Vector<Products> listProductsByCategory(String CategoryID){
        Vector<Products> listCid = new Vector<Products>();
        String sql = "select * from Products where CategoryID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,CategoryID );
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
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
            listCid.add(pro);
            }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        return listCid;
    }
    
    
    
    
    public Vector<Brand> listBrand(String sql){
        Vector<Brand> listB = new Vector<Brand>();
        Statement state;
        try {
            state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = state.executeQuery(sql);
             while(rs.next()){
                  int brandID = rs.getInt(1);
                 String brandName = rs.getString(2);
                 Brand brand = new Brand(brandID, brandName);
                 listB.add(brand);
             }
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
       return listB;
        
    }
    
    
    
public Vector<Category> listCategory(String sql){
    Vector<Category> listC = new Vector<Category>();
    try {
          Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = state.executeQuery(sql);
        while(rs.next()){
              int CategoryID = rs.getInt(1);
              String NameCategory = rs.getString(2);
              
              Category cat = new Category(CategoryID, NameCategory);
              listC.add(cat);
        }
    } catch (SQLException ex) {
       ex.printStackTrace();
    }
    return listC;
}     



 public Vector<Products> listProducts(String sql){
     Vector<Products> proo = new Vector<Products>();
     try {
         Statement state = conn.createStatement();
         ResultSet rs = state.executeQuery(sql);
         while(rs.next()){
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
            proo.add(pro);
         }
     } catch (SQLException ex) {
        ex.printStackTrace();
     }
 return proo;    
 }
 
 

}
