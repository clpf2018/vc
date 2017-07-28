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
class Operation_State implements Serializable { //Draft,Waiting availability ,partially avaialble ,Available , done
    
//* Draft: not confirmed yet and will not be scheduled until confirmed
//* Waiting Another Operation: waiting for another move to proceed before it becomes automatically available (e.g. in Make-To-Order flows)
//* Waiting Availability: still waiting for the availability of products
//* Partially Available: some products are available and reserved
//* Ready to Transfer: products reserved, simply waiting for confirmation.
//* Transferred: has been processed, can't be modified or cancelled anymore
//* Cancelled: has been cancelled, can't be confirmed anymore

    private int ID;
    private String Name;

    public Operation_State(int ID, String Name) {
        this.ID = ID;
        this.Name = Name;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.ID;
        hash = 89 * hash + Objects.hashCode(this.Name);
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
        final Operation_State other = (Operation_State) obj;
        if (this.ID != other.ID) {
            return false;
        }
        if (!Objects.equals(this.Name, other.Name)) {
            return false;
        }
        return true;
    }
    
    
    
}
