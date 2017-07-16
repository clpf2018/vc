/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import java.util.ArrayList;

/**
 *
 * @author joseph
 */
class Product_Category { //Juices , lamps...
    
    private int ID;
    private String Name;
    private ArrayList<Product> produits;

    public Product_Category(int ID, String Name, ArrayList<Product> produits) {
        this.ID = ID;
        this.Name = Name;
        this.produits = produits;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public ArrayList<Product> getProduits() {
        return produits;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setProduits(ArrayList<Product> produits) {
        this.produits = produits;
    }
    
    
    
    
}
