package Model;

import Entity.Products;
import java.util.Vector;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOProducts extends DBConnect {

    public Vector<Products> productsDetails(String sql) {
        Vector<Products> listP = new Vector<Products>();
        try {
            Statement state = conn.createStatement();
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
                listP.add(pro);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listP;
    }

    public int updateQuantity(int pid, int quantityOrder) {
        int n = 0;
        String sql = "UPDATE [dbo].[Products]\n"
                + "   SET \n"
                + "      [Quantity] = quantity -  ? \n"
                + "      \n"
                + " WHERE productID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(2, pid);
            pre.setInt(1, quantityOrder);
            n =pre.executeUpdate();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        return n;
    }

    public Products listProductsByPid(int pId) {
        String sql = "select * from Products where productID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, pId);
            ResultSet rs = pre.executeQuery();
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
                return pro;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Vector<Products> getProducts(String sql) {
        Vector<Products> vector = new Vector<>();
        try {
            Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = statement.executeQuery(sql);

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
                vector.add(pro);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

}
//    public static void main(String[] args) {
//        DAOProducts dao = new DAOProducts();
//        Vector<products> vector = dao.bestSale("select * from Products");
//        for (Products object : vector) {
//            System.out.println(object);
//        }
//    }

