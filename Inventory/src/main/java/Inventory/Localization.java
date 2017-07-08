/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

/**
 *
 * @author joseph
 */
class Localization {
    
    
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
    
}
