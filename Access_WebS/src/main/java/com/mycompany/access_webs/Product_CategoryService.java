/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.access_webs;

import Inventory.Product_Type;
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
class Product_TypeService {
    
    FireBase_DataBase test;
    static DatabaseReference Product_TypeRef;
   static  DatabaseReference ref;
   List<Product_Type> Product_Typees;
    
    Product_TypeService() {
        try {
            this.test = new FireBase_DataBase();
             FirebaseDatabase database = FirebaseDatabase.getInstance();
             ref = database.getReference("");
             Product_TypeRef = ref.child("Product_Type");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Product_TypeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static List<Product_Type> getAllProduct_Typees(){
        
    final List<Product_Type> Product_Typees=new ArrayList<Product_Type>();    
        
// Attach a listener to read the data at our posts reference
Product_TypeRef.addValueEventListener(new ValueEventListener() {
    
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        Product_Type post = dataSnapshot.getValue(Product_Type.class);
        Product_Typees.add(post);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        System.out.println("The read failed: " + databaseError.getCode());
    }
});
        
return Product_Typees;
    }
    
    
    
      public static Product_Type getProduct_TypeForId(String id) {
        
          
            
    }
    
      
      
      
      
      
      public static Product_Type CreateProduct_Type(Product_Type Pro) {
        
         Map<Integer,Product_Type> Product_Typees=new HashMap<Integer,Product_Type>(); //Integer for the ID;
         Product_Typees.put(Pro.getID(), Pro);
         
       Product_TypeRef.setValue(Product_Typees);
       return Pro;
    }
      
      
 
      public static Product_Type updateProduct_Type(Product_Type Pro) {
          
          DatabaseReference NewRef = Product_TypeRef.child(String.valueOf(Pro.getID()));
        Map<String, Object> ProUpdates = new HashMap<String, Object >();
        ProUpdates.put(String.valueOf(Pro.getID()),Pro);
        NewRef.updateChildren(ProUpdates);
        return Pro;
    }
        
      
 
    public static Product_Type deleteProduct_Type(String id) {
       
        DatabaseReference  DelRef= Product_TypeRef.child(id);
        
        DelRef.removeValue();
        
    
    }  

    
      
}
