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
class Localization implements Serializable{
    
    
    private int ID;
    private String Corridor;
    private String Shelf;
    private String Height;
    private Barcode Bar;

    public Localization(int ID, String Corridor, String Shelf, String Height, Barcode Bar) {
        this.ID = ID;
        this.Corridor = Corridor;
        this.Shelf = Shelf;
        this.Height = Height;
        this.Bar = Bar;
    }

    public int getID() {
        return ID;
    }

    public String getCorridor() {
        return Corridor;
    }

    public String getShelf() {
        return Shelf;
    }

    public String getHeight() {
        return Height;
    }

    public Barcode getBar() {
        return Bar;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setCorridor(String Corridor) {
        this.Corridor = Corridor;
    }

    public void setShelf(String Shelf) {
        this.Shelf = Shelf;
    }

    public void setHeight(String Height) {
        this.Height = Height;
    }

    public void setBar(Barcode Bar) {
        this.Bar = Bar;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.ID;
        hash = 67 * hash + Objects.hashCode(this.Corridor);
        hash = 67 * hash + Objects.hashCode(this.Shelf);
        hash = 67 * hash + Objects.hashCode(this.Height);
        hash = 67 * hash + Objects.hashCode(this.Bar);
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
        final Localization other = (Localization) obj;
        if (this.ID != other.ID) {
            return false;
        }
        if (!Objects.equals(this.Corridor, other.Corridor)) {
            return false;
        }
        if (!Objects.equals(this.Shelf, other.Shelf)) {
            return false;
        }
        if (!Objects.equals(this.Height, other.Height)) {
            return false;
        }
        if (!Objects.equals(this.Bar, other.Bar)) {
            return false;
        }
        return true;
    }
    
}
