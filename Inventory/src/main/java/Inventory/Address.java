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
 public class Address implements Serializable{

    
    private int ID;
    private String Street;
    private String City;
    private String State;
    private int ZIP;
    private String Country;
    private String Email;
    private String Contact;
    private String Note;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.ID;
        hash = 17 * hash + Objects.hashCode(this.Street);
        hash = 17 * hash + Objects.hashCode(this.City);
        hash = 17 * hash + Objects.hashCode(this.State);
        hash = 17 * hash + this.ZIP;
        hash = 17 * hash + Objects.hashCode(this.Country);
        hash = 17 * hash + Objects.hashCode(this.Email);
        hash = 17 * hash + Objects.hashCode(this.Contact);
        hash = 17 * hash + Objects.hashCode(this.Note);
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
        final Address other = (Address) obj;
        if (this.ID != other.ID) {
            return false;
        }
        if (this.ZIP != other.ZIP) {
            return false;
        }
        if (!Objects.equals(this.Street, other.Street)) {
            return false;
        }
        if (!Objects.equals(this.City, other.City)) {
            return false;
        }
        if (!Objects.equals(this.State, other.State)) {
            return false;
        }
        if (!Objects.equals(this.Country, other.Country)) {
            return false;
        }
        if (!Objects.equals(this.Email, other.Email)) {
            return false;
        }
        if (!Objects.equals(this.Contact, other.Contact)) {
            return false;
        }
        if (!Objects.equals(this.Note, other.Note)) {
            return false;
        }
        return true;
    }

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
