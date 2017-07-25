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
class Operation_type implements Serializable {
    //Receipts, internal transfer ,Delivery orders
    private int ID;
    private String Name;
    private Address Default_Source;
    private Address Default_Dest;

    public Operation_type(int ID, String Name, Address Default_Source, Address Default_Dest) {
        this.ID = ID;
        this.Name = Name;
        this.Default_Source = Default_Source;
        this.Default_Dest = Default_Dest;
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

    public Address getDefault_Source() {
        return Default_Source;
    }

    public void setDefault_Source(Address Default_Source) {
        this.Default_Source = Default_Source;
    }

    public Address getDefault_Dest() {
        return Default_Dest;
    }

    public void setDefault_Dest(Address Default_Dest) {
        this.Default_Dest = Default_Dest;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.ID;
        hash = 71 * hash + Objects.hashCode(this.Name);
        hash = 71 * hash + Objects.hashCode(this.Default_Source);
        hash = 71 * hash + Objects.hashCode(this.Default_Dest);
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
        final Operation_type other = (Operation_type) obj;
        if (this.ID != other.ID) {
            return false;
        }
        if (!Objects.equals(this.Name, other.Name)) {
            return false;
        }
        if (!Objects.equals(this.Default_Source, other.Default_Source)) {
            return false;
        }
        if (!Objects.equals(this.Default_Dest, other.Default_Dest)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
