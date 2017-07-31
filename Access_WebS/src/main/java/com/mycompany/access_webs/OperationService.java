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

import Inventory.Operation;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class OperationService {
      
    FireBase_DataBase test;
      OperationService() {
        try {
            this.test = new FireBase_DataBase();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddressService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static List<Operation> getAllOperations(){
        
        
    }
    
    
    
      public static Operation getOperationForId(String id) {
        
          
          
    }
    
      
      
      
      
      
      public static Operation CreateOperation(Operation Loc) {
        
    }
      
      
 
      public static Operation updateOperation(Operation Loc) {
        
    }
      
      
 
    public static Operation deleteOperation(String id) {
        
    }  
    
}
