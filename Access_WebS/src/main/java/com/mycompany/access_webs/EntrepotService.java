/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.access_webs;

import Inventory.Entrepot;
import java.util.List;
import com.mycompany.access_webs.FireBase_DataBase;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author joseph
 */
class EntrepotService {
    
      FireBase_DataBase test;
      EntrepotService() {
        try {
            this.test = new FireBase_DataBase();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddressService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static List<Entrepot> getAllEntrepots(){
        
        
    }
    
    
    
      public static Entrepot getEntrepotForId(String id) {
        
    }
    
      
      
      
      
      
      public static Entrepot CreateWarehouse(Entrepot Entre) {
        
    }
      
      
 
      public static Entrepot updateEntrepot(Entrepot Entre) {
        
    }
      
      
 
    public static Entrepot deleteEntrepot(String id) {
        
    }  
    
}
