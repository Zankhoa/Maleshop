/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Entity.OrderItems;
import Entity.Orderr;
import java.util.Vector;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOOrderItems extends DBConnect {

    public Vector<OrderItems> getOrderItems(String sql) {
        Vector<OrderItems> items = new Vector<>();
        Statement state;
        try {
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int ItemsID = rs.getInt(1);
                int quantity = rs.getInt(2);
                int OrderID = rs.getInt(3);
                int ProductID = rs.getInt(4);
                double price = rs.getDouble(5);
                OrderItems order = new OrderItems(ItemsID, quantity, OrderID, ProductID, price);
                items.add(order);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return items;
    }

    public int insertItems(OrderItems items) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[OrderItems]\n"
                + "           ([ItemsID]\n"
                + "           ,[quantity]\n"
                + "           ,[OrderID]\n"
                + "           ,[ProductID]\n"
                + "           ,[price])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?)";

        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, items.getItemsID());
            pre.setInt(2, items.getQuantity());
            pre.setInt(3, items.getOrderID());
            pre.setInt(4, items.getProductID());
            pre.setDouble(5, items.getPrice());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public static void main(String[] args) {
        DAOOrderItems dao = new DAOOrderItems();
        int n = dao.insertItems(new OrderItems(1, 2, 1, 1, 50));
        Vector<OrderItems> vector = dao.getOrderItems("select * from OrderItems");
        for (OrderItems orderItems : vector) {
            System.out.println(orderItems);
        }
    }
}
