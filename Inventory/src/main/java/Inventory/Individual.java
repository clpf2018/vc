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
public class Individual extends Person implements Serializable{
 
private int ID;    
private String job_Position;
private String Title; // Miss , MR , Mrs...

    public Individual(int ID,String Name, String Phone, String Mobile, String Fax, String Email, String job_Position,String Title ) {
        super(ID, Name, Phone, Mobile, Fax, Email);
        this.job_Position=job_Position;
        this.Title=Title;
    }

    
    public void setID(int ID){
     
        
        this.ID=ID;
    }
    
    public int getID(){
        
        
        return this.ID;
        
    }
    public void setJob_Position(String job_Position) {
        this.job_Position = job_Position;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getJob_Position() {
        return job_Position;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.job_Position);
        hash = 11 * hash + Objects.hashCode(this.Title);
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
        final Individual other = (Individual) obj;
        if (!Objects.equals(this.job_Position, other.job_Position)) {
            return false;
        }
        if (!Objects.equals(this.Title, other.Title)) {
            return false;
        }
        return true;
    }

    public String getTitle() {
        return Title;
    }
 
}
