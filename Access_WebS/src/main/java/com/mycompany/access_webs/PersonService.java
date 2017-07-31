/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.access_webs;

import Inventory.Person;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joseph
 */
class PersonService {
    
    FireBase_DataBase test;
      PersonService() {
        try {
            this.test = new FireBase_DataBase();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddressService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static List<Person> getAllPersons(){
        
        
    }
    
    
    
      public static Person getPersonForId(String id) {
        
          
          
    }
    
      
      
      
      
      
      public static Person CreatePerson(Person Pre) {
        
    }
      
      
 
      public static Person updatePerson(Person Pre) {
        
    }
      
      
 
    public static Person deletePerson(String id) {
        
    }  
    
}
