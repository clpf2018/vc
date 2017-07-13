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
class Location {
    
    private int ID;

    public int getID() {
        return ID;
    }

    public String getLocation_Name() {
        return Location_Name;
    }

    public Location_Type getLoc_Type() {
        return Loc_Type;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setLocation_Name(String Location_Name) {
        this.Location_Name = Location_Name;
    }

    public void setLoc_Type(Location_Type Loc_Type) {
        this.Loc_Type = Loc_Type;
    }

    public void setOwner(Person Owner) {
        this.Owner = Owner;
    }

    public void setLocalization(Localization Localization) {
        this.Localization = Localization;
    }

    public void setStrat(Strategy Strat) {
        this.Strat = Strat;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }

    public Person getOwner() {
        return Owner;
    }

    public Localization getLocalization() {
        return Localization;
    }

    public Strategy getStrat() {
        return Strat;
    }

    public String getNote() {
        return Note;
    }

    public Location(int ID, String Location_Name, Location_Type Loc_Type, Person Owner, Localization Localization, Strategy Strat, String Note) {
        this.ID = ID;
        this.Location_Name = Location_Name;
        this.Loc_Type = Loc_Type;
        this.Owner = Owner;
        this.Localization = Localization;
        this.Strat = Strat;
        this.Note = Note;
    }
    private String Location_Name;
    private Location_Type Loc_Type;
    private Person Owner;
    private Localization Localization;
    private Strategy Strat; // Strategie de retrait e.g: FIFO , LIFO...
    private String Note;
    
    
}
