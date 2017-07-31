/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.access_webs;

import Inventory.Individual;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joseph
 */
class IndividualService {
    
    FireBase_DataBase test;
      IndividualService() {
        try {
            this.test = new FireBase_DataBase();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddressService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static List<Individual> getAllIndividuals(){
        
        
    }
    
    
    
      public static Individual getIndividualForId(String id) {
        
          
          
    }
    
      
      
      
      
      
      public static Individual CreateIndividual(Individual Pre) {
        
    }
      
      
 
      public static Individual updateIndividual(Individual Pre) {
        
    }
      
      
 
    public static Individual deleteIndividual(String id) {
        
    }  
    
}
