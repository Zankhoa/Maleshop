/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;


public class Category {
 
    private int CategoryID;
    private String NameCategory;

    public Category() {
    }

    public Category(int CategoryID, String NameCategory) {
        this.CategoryID = CategoryID;
        this.NameCategory = NameCategory;
    }

    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int CategoryID) {
        this.CategoryID = CategoryID;
    }

    public String getNameCategory() {
        return NameCategory;
    }

    public void setNameCategory(String NameCategory) {
        this.NameCategory = NameCategory;
    }

    @Override
    public String toString() {
        return "Category{" + "CategoryID=" + CategoryID + ", NameCategory=" + NameCategory + '}';
    }

 

 
 
}
