/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;


public class Orderr {
    private int OrderID;
    private String OrderDate;
    private String  Statuss;
    private int AccountID;

    public Orderr() {
    }

    public Orderr(int OrderID, String OrderDate, String Statuss, int AccountID) {
        this.OrderID = OrderID;
        this.OrderDate = OrderDate;
        this.Statuss = Statuss;
        this.AccountID = AccountID;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String OrderDate) {
        this.OrderDate = OrderDate;
    }

    public String getStatuss() {
        return Statuss;
    }

    public void setStatuss(String Statuss) {
        this.Statuss = Statuss;
    }

    public int getAccountID() {
        return AccountID;
    }

    public void setAccountID(int AccountID) {
        this.AccountID = AccountID;
    }

    @Override
    public String toString() {
        return "Orderr{" + "OrderID=" + OrderID + ", OrderDate=" + OrderDate + ", Statuss=" + Statuss + ", AccountID=" + AccountID + '}';
    }

 

  

    
   
}
