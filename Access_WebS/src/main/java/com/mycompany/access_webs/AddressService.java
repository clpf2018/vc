/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.access_webs;

import Inventory.Address;
import java.util.List;
import com.mycompany.access_webs.FireBase_DataBase;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joseph
 */
class AddressService {
    
    FireBase_DataBase test;
    
    
    
    
    public static List<Address> getAllAddresses(){
        
        
    }
    
    
    
      public static Address getAddressForId(String id) {
        
    }
    
      
      
      
      
      
      public static Address CreateAddress(Address Addr) {
        
    }
      
      
 
      public static Address updateAddress(Address Addr) {
        
    }
      
      
 
    public static Address deleteAddress(String id) {
        
    }  

    AddressService() {
        try {
            this.test = new FireBase_DataBase();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddressService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
}
