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
public class Entrepot implements Serializable{
    
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.ID;
        hash = 89 * hash + Objects.hashCode(this.Name);
        hash = 89 * hash + Objects.hashCode(this.Short_Name);
        hash = 89 * hash + Objects.hashCode(this.Adr);
        hash = 89 * hash + Objects.hashCode(this.Loc);
        hash = 89 * hash + Objects.hashCode(this.Re_Supply);
        hash = 89 * hash + Objects.hashCode(this.Note);
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
        final Entrepot other = (Entrepot) obj;
        if (this.ID != other.ID) {
            return false;
        }
        if (!Objects.equals(this.Name, other.Name)) {
            return false;
        }
        if (!Objects.equals(this.Short_Name, other.Short_Name)) {
            return false;
        }
        if (!Objects.equals(this.Note, other.Note)) {
            return false;
        }
        if (!Objects.equals(this.Adr, other.Adr)) {
            return false;
        }
        if (!Objects.equals(this.Loc, other.Loc)) {
            return false;
        }
        if (!Objects.equals(this.Re_Supply, other.Re_Supply)) {
            return false;
        }
        return true;
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
