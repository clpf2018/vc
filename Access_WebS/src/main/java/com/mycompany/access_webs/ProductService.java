/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.access_webs;

import Inventory.Product;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.tasks.Task;
import java.util.List;
import com.mycompany.access_webs.FireBase_DataBase;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joseph
 */
class ProductService {
    
    FireBase_DataBase test;
    static DatabaseReference ProductRef;
   static  DatabaseReference ref;
   List<Product> Productes;
    
    ProductService() {
        try {
            this.test = new FireBase_DataBase();
             FirebaseDatabase database = FirebaseDatabase.getInstance();
             ref = database.getReference("");
             ProductRef = ref.child("Product");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static List<Product> getAllProductes(){
        
    final List<Product> Productes=new ArrayList<Product>();    
        
// Attach a listener to read the data at our posts reference
ProductRef.addValueEventListener(new ValueEventListener() {
    
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        Product post = dataSnapshot.getValue(Product.class);
        Productes.add(post);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        System.out.println("The read failed: " + databaseError.getCode());
    }
});
        
return Productes;
    }
    
    
    
      public static Product getProductForId(String id) {
        
          
            
    }
    
      
      
      
      
      
      public static Product CreateProduct(Product Pro) {
        
         Map<Integer,Product> Productes=new HashMap<Integer,Product>(); //Integer for the ID;
         Productes.put(Pro.getID(), Pro);
         
       ProductRef.setValue(Productes);
       return Pro;
    }
      
      
 
      public static Product updateProduct(Product Pro) {
          
          DatabaseReference NewRef = ProductRef.child(String.valueOf(Pro.getID()));
        Map<String, Object> ProUpdates = new HashMap<String, Object >();
        ProUpdates.put(String.valueOf(Pro.getID()),Pro);
        NewRef.updateChildren(ProUpdates);
        return Pro;
    }
        
      
 
    public static Product deleteProduct(String id) {
       
        DatabaseReference  DelRef= ProductRef.child(id);
        
        DelRef.removeValue();
        
    
    }  

    
      
}
