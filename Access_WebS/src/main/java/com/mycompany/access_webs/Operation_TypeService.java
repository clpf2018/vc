/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.access_webs;

/**
 *
 * @author joseph
 */

import Inventory.Operation_type;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Operation_TypeService {
      
    FireBase_DataBase test;
      Operation_TypeService() {
        try {
            this.test = new FireBase_DataBase();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddressService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static List<Operation_type> getAllOperation_types(){
        
        
    }
    
    
    
      public static Operation_type getOperation_typeForId(String id) {
        
          
          
    }
    
      
      
      
      
      
      public static Operation_type CreateOperation_type(Operation_type Loc) {
        
    }
      
      
 
      public static Operation_type updateOperation_type(Operation_type Loc) {
        
    }
      
      
 
    public static Operation_type deleteOperation_type(String id) {
        
    }  
    
}
