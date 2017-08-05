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
public class Person implements Serializable{

    
    
     // ID, Phone, Mobile, Fax, Email
            
   private int ID;
   String Name;
   private String Phone;
   private String Mobile;
   private String Fax;
   private String Emai;

    public Person(int ID, String Name,String Phone, String Mobile, String Fax, String Emai) {
        this.ID = ID;
        this.Name=Name;
        this.Phone = Phone;
        this.Mobile = Mobile;
        this.Fax = Fax;
        this.Emai = Emai;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + this.ID;
        hash = 19 * hash + Objects.hashCode(this.Name);
        hash = 19 * hash + Objects.hashCode(this.Phone);
        hash = 19 * hash + Objects.hashCode(this.Mobile);
        hash = 19 * hash + Objects.hashCode(this.Fax);
        hash = 19 * hash + Objects.hashCode(this.Emai);
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
        final Person other = (Person) obj;
        if (this.ID != other.ID) {
            return false;
        }
        if (!Objects.equals(this.Name, other.Name)) {
            return false;
        }
        if (!Objects.equals(this.Phone, other.Phone)) {
            return false;
        }
        if (!Objects.equals(this.Mobile, other.Mobile)) {
            return false;
        }
        if (!Objects.equals(this.Fax, other.Fax)) {
            return false;
        }
        if (!Objects.equals(this.Emai, other.Emai)) {
            return false;
        }
        return true;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String Mobile) {
        this.Mobile = Mobile;
    }

    public String getFax() {
        return Fax;
    }

    public void setFax(String Fax) {
        this.Fax = Fax;
    }

    public String getEmai() {
        return Emai;
    }

    public void setEmai(String Emai) {
        this.Emai = Emai;
    }
    
  
}
