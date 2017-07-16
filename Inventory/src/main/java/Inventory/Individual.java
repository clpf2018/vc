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
public class Individual extends Person {
 
private String job_Position;
private String Title; // Miss , MR , Mrs...

    public Individual(int ID,String Name, String Phone, String Mobile, String Fax, String Email, String job_Position,String Title ) {
        super(ID, Name, Phone, Mobile, Fax, Email);
        this.job_Position=job_Position;
        this.Title=Title;
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

    public String getTitle() {
        return Title;
    }
 
}
