/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author joseph
 */
public class Entrepot {
    
    private int ID;
    private String Name;
    private String Short_Name;
    private Address Adr;
    private Map<String,Location> Loc;
    private Entrepot Re_Supply;
    private String Note;
    private Operation Opt;

    public Entrepot(int ID, String Name, String Short_Name, Address Adr, Map<String, Location> Loc, Entrepot Re_Supply, String Note, Operation Opt) {
        this.ID = ID;
        this.Name = Name;
        this.Short_Name = Short_Name;
        this.Adr = Adr;
        this.Loc = Loc;
        this.Re_Supply = Re_Supply;
        this.Note = Note;
        this.Opt = Opt;
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

    public Map<String, Location> getLoc() {
        return Loc;
    }

    public Entrepot getRe_Supply() {
        return Re_Supply;
    }

    public String getNote() {
        return Note;
    }

    public Operation getOpt() {
        return Opt;
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

    public void setLoc(Map<String, Location> Loc) {
        this.Loc = Loc;
    }

    public void setRe_Supply(Entrepot Re_Supply) {
        this.Re_Supply = Re_Supply;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }

    public void setOpt(Operation Opt) {
        this.Opt = Opt;
    }

    @Override
    public String toString() {
        return "Entrepot{" + "ID=" + ID + ", Name=" + Name + ", Short_Name=" + Short_Name + ", Adr=" + Adr + ", Loc=" + Loc + ", Re_Supply=" + Re_Supply + ", Note=" + Note + ", Opt=" + Opt + '}';
    }
    

    
    
    
    
    
    
}
