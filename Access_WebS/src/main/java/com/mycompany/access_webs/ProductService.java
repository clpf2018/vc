/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.access_webs;

import Inventory.Product;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joseph
 */
class ProductService {
    
    FireBase_DataBase test;
      ProductService() {
        try {
            this.test = new FireBase_DataBase();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddressService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static List<Product> getAllProducts(){
        
        
    }
    
    
    
      public static Product getProductForId(String id) {
        
          
          
    }
    
      
      
      
      
      
      public static Product CreateProduct(Product Pre) {
        
    }
      
      
 
      public static Product updateProduct(Product Pre) {
        
    }
      
      
 
    public static Product deleteProduct(String id) {
        
    }  
    
}
