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
class Person {
    
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
    
}
