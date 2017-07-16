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
    private Product_Category parent; //parent category

    public Product_Category( String Name, Product_Category parent) {
        
        this.Name = Name;
        this.parent=parent;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }
    
    public Product_Category getParent(){
        return this.parent;
    }

   
    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setParent(Product_Category parent){
        this.parent=parent;
    }
    
    
    
}
