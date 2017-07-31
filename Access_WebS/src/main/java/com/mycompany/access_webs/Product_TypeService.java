/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.access_webs;

import Inventory.Product_Type;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joseph
 */
class Product_TypeService {
    
    FireBase_DataBase test;
      Product_TypeService() {
        try {
            this.test = new FireBase_DataBase();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddressService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static List<Product_Type> getAllProduct_Types(){
        
        
    }
    
    
    
      public static Product_Type getProduct_TypeForId(String id) {
        
          
          
    }
    
      
      
      
      
      
      public static Product_Type CreateProduct_Type(Product_Type Pre) {
        
    }
      
      
 
      public static Product_Type updateProduct_Type(Product_Type Pre) {
        
    }
      
      
 
    public static Product_Type deleteProduct_Type(String id) {
        
    }  
    
}
