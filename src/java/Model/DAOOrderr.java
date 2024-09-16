/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this licens
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Entity.Account;
import Entity.Orderr;
import java.util.Vector;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOOrderr extends DBConnect {

    public int getMaxId() {
        int id = 0;
        ResultSet rs = getData("select MAX(OrderID) from Orderr");
        try {
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return id;
    }

    public Vector<Orderr> getOrder(String sql) {
        Vector<Orderr> or = new Vector<>();
        try {
            Statement state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int OrderID = rs.getInt(1);
                String OrderDate = rs.getString(2);
                String Statuss = rs.getString(3);
                int AccountID = rs.getInt(4);

                Orderr order = new Orderr(OrderID, OrderDate, Statuss, AccountID);
                or.add(order);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return or;
    }

    public int insertOrder(Orderr or) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Orderr]\n"
                + "           ([OrderID]\n"
                + "           ,[OrderDate]\n"
                + "           ,[Statuss]\n"
                + "           ,[AccountID])\n"
                + "     VALUES\n"
                + "           (?,?,?,?)";

        try {
            PreparedStatement pre = conn.prepareStatement(sql);
             pre.setInt(1, or.getOrderID());
            pre.setString(2, or.getOrderDate());
            pre.setString(3, or.getStatuss());
            pre.setInt(4, or.getAccountID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    
    public double getTotalOrder(int orderId){
        String sql = "select sum(price) as total from OrderItems where orderid = ?";
        double total = 0;
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, orderId);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                total = rs.getDouble(1);
            }
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        return total;
    }

    public static void main(String[] args) {
        DAOOrderr dao = new DAOOrderr();
        int n = dao.insertOrder(new Orderr(1, "22-03-2004", "waiting", 2));
        Vector<Orderr> vector = dao.getOrder("select * from Orderr");
        for (Orderr orderr : vector) {
            System.out.println(orderr);
        }
    }
}
