/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.access_webs;

import Inventory.Operation_State;
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
class Operation_StateService {
    
    FireBase_DataBase test;
    static DatabaseReference Operation_StateRef;
   static  DatabaseReference ref;
   List<Operation_State> Operation_Statees;
    
    Operation_StateService() {
        try {
            this.test = new FireBase_DataBase();
             FirebaseDatabase database = FirebaseDatabase.getInstance();
             ref = database.getReference("");
             Operation_StateRef = ref.child("Operation_State");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Operation_StateService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static List<Operation_State> getAllOperation_Statees(){
        
    final List<Operation_State> Operation_Statees=new ArrayList<Operation_State>();    
        
// Attach a listener to read the data at our posts reference
Operation_StateRef.addValueEventListener(new ValueEventListener() {
    
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        Operation_State post = dataSnapshot.getValue(Operation_State.class);
        Operation_Statees.add(post);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        System.out.println("The read failed: " + databaseError.getCode());
    }
});
        
return Operation_Statees;
    }
    
    
    
      public static Operation_State getOperation_StateForId(String id) {
        
          
            
    }
    
      
      
      
      
      
      public static Operation_State CreateOperation_State(Operation_State Opt) {
        
         Map<Integer,Operation_State> Operation_Statees=new HashMap<Integer,Operation_State>(); //Integer for the ID;
         Operation_Statees.put(Opt.getID(), Opt);
         
       Operation_StateRef.setValue(Operation_Statees);
       return Opt;
    }
      
      
 
      public static Operation_State updateOperation_State(Operation_State Opt) {
          
          DatabaseReference NewRef = Operation_StateRef.child(String.valueOf(Opt.getID()));
        Map<String, Object> OptUpdates = new HashMap<String, Object >();
        OptUpdates.put(String.valueOf(Opt.getID()),Opt);
        NewRef.updateChildren(OptUpdates);
        return Opt;
    }
        
      
 
    public static Operation_State deleteOperation_State(String id) {
       
        DatabaseReference  DelRef= Operation_StateRef.child(id);
        
        DelRef.removeValue();
        
    
    }  

    
      
}
