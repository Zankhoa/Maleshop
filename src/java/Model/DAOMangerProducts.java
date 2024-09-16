/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Entity.Products;
import java.util.Vector;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOMangerProducts extends DBConnect {

    public Vector<Products> listProducts(String sql) {
        Vector<Products> managerProducts = new Vector<>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
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
                managerProducts.add(pro);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return managerProducts;
    }

    public int delete(int pid) {
        int n = 0;
        String sql = "DELETE FROM [dbo].[Products]\n"
                + "      WHERE ProductID = ? ";
        try {
            PreparedStatement pre =conn.prepareStatement(sql);
            pre.setInt(1, pid);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        return n;
    }

    public int insert(Products product) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Products]\n"
                + "           ([productName]\n"
                + "           ,[yearofproducts]\n"
                + "           ,[img]\n"
                + "           ,[price]\n"
                + "           ,[Describe]\n"
                + "           ,[Quantity]\n"
                + "           ,[CategoryID]\n"
                + "           ,[brandID])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);

            pre.setString(1, product.getProductName());
            pre.setInt(2, product.getYearofproducts());
            pre.setString(3, product.getImg());
            pre.setDouble(4, product.getPrice());
            pre.setString(5, product.getDescribe());
            pre.setInt(6, product.getQuantity());
            pre.setInt(7, product.getCategoryID());
            pre.setInt(8, product.getBrandID());

            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public int update(Products product) {
        int n = 0;
        String sql = "UPDATE [dbo].[Products]\n"
                + "   SET [productName] = ?\n"
                + "      ,[yearofproducts] = ?\n"
                + "      ,[img] = ?\n"
                + "      ,[price] = ?\n"
                + "      ,[Describe] = ?\n"
                + "      ,[Quantity] = ?\n"
                + "      ,[CategoryID] = ?\n"
                + "      ,[brandID] = ?\n"
                + " WHERE productID = ?";

        try {
            
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(9, product.getProductID());
            pre.setString(1, product.getProductName());
            pre.setInt(2, product.getYearofproducts());
            pre.setString(3, product.getImg());
            pre.setDouble(4, product.getPrice());
            pre.setString(5, product.getDescribe());
            pre.setInt(6, product.getQuantity());
            pre.setInt(7, product.getCategoryID());
            pre.setInt(8, product.getBrandID());

            n = pre.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public static void main(String[] args) {
        DAOMangerProducts dao = new DAOMangerProducts();
        int n = dao.update(new Products(37, "khoaaa", 2024, "21.jpg", 233, "hay lam hehe", 10, 2, 1));
        Vector<Products> vector = dao.listProducts("select * from Products");
        for (Products products : vector) {
            System.out.println(products);
        }
    }
}
