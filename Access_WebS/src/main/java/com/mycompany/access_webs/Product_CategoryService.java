/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.access_webs;

import Inventory.Product_Category;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joseph
 */
class Product_CategoryService {
    
    FireBase_DataBase test;
      Product_CategoryService() {
        try {
            this.test = new FireBase_DataBase();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddressService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static List<Product_Category> getAllProduct_Categorys(){
        
        
    }
    
    
    
      public static Product_Category getProduct_CategoryForId(String id) {
        
          
          
    }
    
      
      
      
      
      
      public static Product_Category CreateProduct_Category(Product_Category Pre) {
        
    }
      
      
 
      public static Product_Category updateProduct_Category(Product_Category Pre) {
        
    }
      
      
 
    public static Product_Category deleteProduct_Category(String id) {
        
    }  
    
}
