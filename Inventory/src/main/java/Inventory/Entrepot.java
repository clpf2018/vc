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
public class Entrepot {
    
    private int ID;
    private String Name;
    private String Short_Name;
    private Address Adr;
    private ArrayList<Location> Loc;
    private Entrepot Re_Supply;
    private String Note;
    

    public Entrepot( String Name, String Short_Name, Address Adr, Location Loc, Entrepot Re_Supply, String Note) {
        
        this.Name = Name;
        this.Short_Name = Short_Name;
        this.Adr = Adr;
        this.Loc.add(Loc);
        this.Re_Supply = Re_Supply;
        this.Note = Note;
        
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getShort_Name() {
        return Short_Name;
    }

    public Address getAdr() {
        return Adr;
    }

    public ArrayList<Location> getLoc() {
        return Loc;
    }

    public Entrepot getRe_Supply() {
        return Re_Supply;
    }

    public String getNote() {
        return Note;
    }

   

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setShort_Name(String Short_Name) {
        this.Short_Name = Short_Name;
    }

    public void setAdr(Address Adr) {
        this.Adr = Adr;
    }

    public void setLoc(Location Loc) {
        this.Loc.add(Loc);
    }

    public void setRe_Supply(Entrepot Re_Supply) {
        this.Re_Supply = Re_Supply;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }

    

    
    
    
    
    
    
}
