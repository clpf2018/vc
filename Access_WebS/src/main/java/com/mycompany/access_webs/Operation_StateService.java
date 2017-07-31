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

import Inventory.Operation_State;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Operation_StateService {
      
    FireBase_DataBase test;
      Operation_StateService() {
        try {
            this.test = new FireBase_DataBase();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddressService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static List<Operation_State> getAllOperation_States(){
        
        
    }
    
    
    
      public static Operation_State getOperation_StateForId(String id) {
        
          
          
    }
    
      
      
      
      
      
      public static Operation_State CreateOperation_State(Operation_State Loc) {
        
    }
      
      
 
      public static Operation_State updateOperation_State(Operation_State Loc) {
        
    }
      
      
 
    public static Operation_State deleteOperation_State(String id) {
        
    }  
    
}
