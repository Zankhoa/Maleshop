/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Entity.Account;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoAccount extends DBConnect {

    private final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public Account loginAccount(String userNamee, String passWordd) {
        String sql = "select * from account where username = ? and PassWord = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, userNamee);
            pre.setString(2, passWordd);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                int AcountID = rs.getInt(1),
                        isAdmin = rs.getInt(2);
                String userName = rs.getString(3),
                        passWord = rs.getString(4),
                        fullname = rs.getString(5),
                        phone = rs.getString(6),
                        email = rs.getString(7);
                Account acc = new Account(AcountID, isAdmin, userName, passWord, fullname, phone, email);
                return acc;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public int insert(Account acc) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[Account]\n"
                + "           ([isAdmin]\n"
                + "           ,[UserName]\n"
                + "           ,[PassWord]\n"
                + "           ,[Fullname]\n"
                + "           ,[Phone]\n"
                + "           ,[email])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, acc.getIsAdmin());
            pre.setString(2, acc.getUserName());
            pre.setString(3, acc.getPassWord());
            pre.setString(4, acc.getFullname());
            pre.setString(5, acc.getPhone());
            pre.setString(6, acc.getEmail());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    public Account getAccount(String sql) {
        try {
            Statement state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int AcountID = rs.getInt(1),
                        isAdmin = rs.getInt(2);
                String userName = rs.getString(3),
                        passWord = rs.getString(4),
                        fullname = rs.getString(5),
                        phone = rs.getString(6),
                        email = rs.getString(7);
                Account acc = new Account(AcountID, isAdmin, userName, passWord, fullname, phone, email);
                return acc;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Vector<Account> getAccountt(String sql) {
        Vector<Account> vector = new Vector<>();
        try {
            Statement state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int AcountID = rs.getInt(1),
                        isAdmin = rs.getInt(2);
                String userName = rs.getString(3),
                        passWord = rs.getString(4),
                        fullname = rs.getString(5),
                        phone = rs.getString(6),
                        email = rs.getString(7);
                Account acc = new Account(AcountID, isAdmin, userName, passWord, fullname, phone, email);
                vector.add(acc);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }
    
     public int findIdByEmail(String email) {
        String sql = "select AccountID from account where email = ?";
        int userId = -1;
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, email);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                userId = rs.getInt("AccountID");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return userId;
    }
    
    public boolean checkEmail(String email) {
        String sql = "select * from account where email = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, email);
            ResultSet rs = pre.executeQuery();
            if (!rs.next()) {
                return false;
            } else {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public String generateRandomString() {
        StringBuilder sb = new StringBuilder(8);
        Random r = new Random();
        for (int i = 0; i < 8; i++) {
            int index = r.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }
        return sb.toString();
    }

    public void changePassword(int AccountID, String newPassword) {
        String sqlupdate = "UPDATE [dbo].[Account]\n"
                + "   SET PassWord = ?\n"
                + " WHERE AccountID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sqlupdate);
            pre.setInt(2, AccountID);
            pre.setString(1, newPassword);
            pre.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DaoAccount dao = new DaoAccount();
       int id = 1;
       STring 
    }

}
