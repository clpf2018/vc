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
 public class Address {

    
    private int ID;
    private String Street;
    private String City;
    private String State;
    private int ZIP;
    private String Country;
    private String Email;
    private String Contact;
    private String Note;

    public int getID() {
        return ID;
    }

    public String getStreet() {
        return Street;
    }

    public String getCity() {
        return City;
    }

    public String getState() {
        return State;
    }

    public int getZIP() {
        return ZIP;
    }

    public String getCountry() {
        return Country;
    }

    public String getEmail() {
        return Email;
    }

    public String getContact() {
        return Contact;
    }

    public String getNote() {
        return Note;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setStreet(String Street) {
        this.Street = Street;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public void setState(String State) {
        this.State = State;
    }

    public void setZIP(int ZIP) {
        this.ZIP = ZIP;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setContact(String Contact) {
        this.Contact = Contact;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }
    
    public Address(int ID, String Street, String City, String State, int ZIP, String Country, String Email, String Contact, String Note) {
        this.ID = ID;
        this.Street = Street;
        this.City = City;
        this.State = State;
        this.ZIP = ZIP;
        this.Country = Country;
        this.Email = Email;
        this.Contact = Contact;
        this.Note = Note;
    }
   
    
    
    
}
