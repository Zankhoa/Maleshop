/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

public class OrderItems {
    
    private int ItemsID;
    private int quantity;
    private int OrderID;
    private int ProductID;
    private double price;

    public OrderItems() {
    }

    public OrderItems(int ItemsID, int quantity, int OrderID, int ProductID, double price) {
        this.ItemsID = ItemsID;
        this.quantity = quantity;
        this.OrderID = OrderID;
        this.ProductID = ProductID;
        this.price = price;
    }

    public int getItemsID() {
        return ItemsID;
    }

    public void setItemsID(int ItemsID) {
        this.ItemsID = ItemsID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderItems{" + "ItemsID=" + ItemsID + ", quantity=" + quantity + ", OrderID=" + OrderID + ", ProductID=" + ProductID + ", price=" + price + '}';
    }

}
