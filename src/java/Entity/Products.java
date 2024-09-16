/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;


public class Products {

private int productID;
private String productName;
private int yearofproducts;
private String img;
private double price;
private String describe;
private int quantity;
private int categoryID;
private int brandID;

    public Products() {
    }

    public Products(String productName, int yearofproducts, String img, double price, String describe, int quantity, int categoryID, int brandID) {
        this.productName = productName;
        this.yearofproducts = yearofproducts;
        this.img = img;
        this.price = price;
        this.describe = describe;
        this.quantity = quantity;
        this.categoryID = categoryID;
        this.brandID = brandID;
    }
    
 public Products(int productID, String productName, String img, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.img = img;
        this.price = price;
        this.quantity = quantity;
    }
 
    public Products(int productID, String productName, int yearofproducts, String img, double price, String describe, int quantity, int categoryID, int brandID) {
        this.productID = productID;
        this.productName = productName;
        this.yearofproducts = yearofproducts;
        this.img = img;
        this.price = price;
        this.describe = describe;
        this.quantity = quantity;
        this.categoryID = categoryID;
        this.brandID = brandID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getYearofproducts() {
        return yearofproducts;
    }

    public void setYearofproducts(int yearofproducts) {
        this.yearofproducts = yearofproducts;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getBrandID() {
        return brandID;
    }

    public void setBrandID(int brandID) {
        this.brandID = brandID;
    }

    @Override
    public String toString() {
        return "Products{" + "productID=" + productID + ", productName=" + productName + ", yearofproducts=" + yearofproducts + ", img=" + img + ", price=" + price + ", describe=" + describe + ", quantity=" + quantity + ", categoryID=" + categoryID + ", brandID=" + brandID + '}';
    }
    

}