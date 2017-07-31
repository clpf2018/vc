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

import Inventory.Location;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class LocationService {
      
    FireBase_DataBase test;
      LocationService() {
        try {
            this.test = new FireBase_DataBase();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddressService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static List<Location> getAllLocations(){
        
        
    }
    
    
    
      public static Location getLocationForId(String id) {
        
          
          
    }
    
      
      
      
      
      
      public static Location CreateLocation(Location Loc) {
        
    }
      
      
 
      public static Location updateLocation(Location Loc) {
        
    }
      
      
 
    public static Location deleteLocation(String id) {
        
    }  
    
}
