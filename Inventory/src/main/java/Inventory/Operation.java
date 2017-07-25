/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author joseph
 */
class Operation implements Serializable{
    
    private int ID;
    private Person peron;
    private Address Source;
    private Address Destination;
    private Date Scheduled_Date;
    private Operation_type Opt;
    private ArrayList<Product> products_demand;
    private Operation_State State;
    private String Reference_Sequence;

    public Operation(int ID, Person peron, Address Source, Address Destination, Date Scheduled_Date, Operation_type Opt, ArrayList<Product> products_demand, Operation_State State, String Reference_Sequence) {
        this.ID = ID;
        this.peron = peron;
        this.Source = Source;
        this.Destination = Destination;
        this.Scheduled_Date = Scheduled_Date;
        this.Opt = Opt;
        this.products_demand = products_demand;
        this.State = State;
        this.Reference_Sequence = Reference_Sequence;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Person getPeron() {
        return peron;
    }

    public void setPeron(Person peron) {
        this.peron = peron;
    }

    public Address getSource() {
        return Source;
    }

    public void setSource(Address Source) {
        this.Source = Source;
    }

    public Address getDestination() {
        return Destination;
    }

    public void setDestination(Address Destination) {
        this.Destination = Destination;
    }

    public Date getScheduled_Date() {
        return Scheduled_Date;
    }

    public void setScheduled_Date(Date Scheduled_Date) {
        this.Scheduled_Date = Scheduled_Date;
    }

    public Operation_type getOpt() {
        return Opt;
    }

    public void setOpt(Operation_type Opt) {
        this.Opt = Opt;
    }

    public ArrayList<Product> getProducts_demand() {
        return products_demand;
    }

    public void setProducts_demand(ArrayList<Product> products_demand) {
        this.products_demand = products_demand;
    }

    public Operation_State getState() {
        return State;
    }

    public void setState(Operation_State State) {
        this.State = State;
    }

    public String getReference_Sequence() {
        return Reference_Sequence;
    }

    public void setReference_Sequence(String Reference_Sequence) {
        this.Reference_Sequence = Reference_Sequence;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.ID;
        hash = 41 * hash + Objects.hashCode(this.peron);
        hash = 41 * hash + Objects.hashCode(this.Source);
        hash = 41 * hash + Objects.hashCode(this.Destination);
        hash = 41 * hash + Objects.hashCode(this.Scheduled_Date);
        hash = 41 * hash + Objects.hashCode(this.Opt);
        hash = 41 * hash + Objects.hashCode(this.products_demand);
        hash = 41 * hash + Objects.hashCode(this.State);
        hash = 41 * hash + Objects.hashCode(this.Reference_Sequence);
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
        final Operation other = (Operation) obj;
        if (this.ID != other.ID) {
            return false;
        }
        if (!Objects.equals(this.Reference_Sequence, other.Reference_Sequence)) {
            return false;
        }
        if (!Objects.equals(this.peron, other.peron)) {
            return false;
        }
        if (!Objects.equals(this.Source, other.Source)) {
            return false;
        }
        if (!Objects.equals(this.Destination, other.Destination)) {
            return false;
        }
        if (!Objects.equals(this.Scheduled_Date, other.Scheduled_Date)) {
            return false;
        }
        if (!Objects.equals(this.Opt, other.Opt)) {
            return false;
        }
        if (!Objects.equals(this.products_demand, other.products_demand)) {
            return false;
        }
        if (!Objects.equals(this.State, other.State)) {
            return false;
        }
        return true;
    }
    
    
}
