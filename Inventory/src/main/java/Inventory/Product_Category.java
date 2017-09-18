/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author joseph
 */
class Product_Category implements Serializable{ //Juices , lamps...
    
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.ID;
        hash = 73 * hash + Objects.hashCode(this.Name);
        hash = 73 * hash + Objects.hashCode(this.parent);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product_Category other = (Product_Category) obj;
        if (this.ID != other.ID) {
            return false;
        }
        if (!Objects.equals(this.Name, other.Name)) {
            return false;
        }
        if (!Objects.equals(this.parent, other.parent)) {
            return false;
        }
        return true;
    }
    
    
    
}
