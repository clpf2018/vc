/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author joseph
 */
class Barcode implements Serializable {

    
     private int ID;
    private String Barcode_value;
    private String Barcode_Type;

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setBarcode_value(String Barcode_value) {
        this.Barcode_value = Barcode_value;
    }

    public void setBarcode_Type(String Barcode_Type) {
        this.Barcode_Type = Barcode_Type;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + this.ID;
        hash = 43 * hash + Objects.hashCode(this.Barcode_value);
        hash = 43 * hash + Objects.hashCode(this.Barcode_Type);
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
        final Barcode other = (Barcode) obj;
        if (this.ID != other.ID) {
            return false;
        }
        if (!Objects.equals(this.Barcode_value, other.Barcode_value)) {
            return false;
        }
        if (!Objects.equals(this.Barcode_Type, other.Barcode_Type)) {
            return false;
        }
        return true;
    }
  
    
   
    public Barcode(int ID, String Barcode_value, String Barcode_Type) {
        this.ID = ID;
        this.Barcode_value = Barcode_value;
        this.Barcode_Type = Barcode_Type;
    }

    public int getID() {
        return ID;
    }

    public String getBarcode_value() {
        return Barcode_value;
    }

    public String getBarcode_Type() {
        return Barcode_Type;
    }
    
    
    
    
}


