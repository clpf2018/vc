/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.access_webs;

import Inventory.Operation_type;
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
class Operation_typeService {
    
    FireBase_DataBase test;
    static DatabaseReference Operation_typeRef;
   static  DatabaseReference ref;
   List<Operation_type> Operation_typees;
    
    Operation_typeService() {
        try {
            this.test = new FireBase_DataBase();
             FirebaseDatabase database = FirebaseDatabase.getInstance();
             ref = database.getReference("");
             Operation_typeRef = ref.child("Operation_type");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Operation_typeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static List<Operation_type> getAllOperation_typees(){
        
    final List<Operation_type> Operation_typees=new ArrayList<Operation_type>();    
        
// Attach a listener to read the data at our posts reference
Operation_typeRef.addValueEventListener(new ValueEventListener() {
    
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        Operation_type post = dataSnapshot.getValue(Operation_type.class);
        Operation_typees.add(post);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        System.out.println("The read failed: " + databaseError.getCode());
    }
});
        
return Operation_typees;
    }
    
    
    
      public static Operation_type getOperation_typeForId(String id) {
        
          
            
    }
    
      
      
      
      
      
      public static Operation_type CreateOperation_type(Operation_type Opt) {
        
         Map<Integer,Operation_type> Operation_typees=new HashMap<Integer,Operation_type>(); //Integer for the ID;
         Operation_typees.put(Opt.getID(), Opt);
         
       Operation_typeRef.setValue(Operation_typees);
       return Opt;
    }
      
      
 
      public static Operation_type updateOperation_type(Operation_type Opt) {
          
          DatabaseReference NewRef = Operation_typeRef.child(String.valueOf(Opt.getID()));
        Map<String, Object> OptUpdates = new HashMap<String, Object >();
        OptUpdates.put(String.valueOf(Opt.getID()),Opt);
        NewRef.updateChildren(OptUpdates);
        return Opt;
    }
        
      
 
    public static Operation_type deleteOperation_type(String id) {
       
        DatabaseReference  DelRef= Operation_typeRef.child(id);
        
        DelRef.removeValue();
        
    
    }  

    
      
}
