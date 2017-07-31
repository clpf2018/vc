/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.access_webs;

import Inventory.Localization;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joseph
 */
class LocalizationService {
    
    
    
     
    FireBase_DataBase test;
      LocalizationService() {
        try {
            this.test = new FireBase_DataBase();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddressService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static List<Localization> getAllLocalizations(){
        
        
    }
    
    
    
      public static Localization getLocalizationForId(String id) {
        
          
          
    }
    
      
      
      
      
      
      public static Localization CreateLocalization(Localization Loc) {
        
    }
      
      
 
      public static Localization updateLocalization(Localization Loc) {
        
    }
      
      
 
    public static Localization deleteLocalization(String id) {
        
    }  
}
