/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.access_webs;

import Inventory.Operation;
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
class OperationService {
    
    FireBase_DataBase test;
    static DatabaseReference OperationRef;
   static  DatabaseReference ref;
   List<Operation> Operationes;
    
    OperationService() {
        try {
            this.test = new FireBase_DataBase();
             FirebaseDatabase database = FirebaseDatabase.getInstance();
             ref = database.getReference("");
             OperationRef = ref.child("Operation");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OperationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static List<Operation> getAllOperationes(){
        
    final List<Operation> Operationes=new ArrayList<Operation>();    
        
// Attach a listener to read the data at our posts reference
OperationRef.addValueEventListener(new ValueEventListener() {
    
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        Operation post = dataSnapshot.getValue(Operation.class);
        Operationes.add(post);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        System.out.println("The read failed: " + databaseError.getCode());
    }
});
        
return Operationes;
    }
    
    
    
      public static Operation getOperationForId(String id) {
        
          
            
    }
    
      
      
      
      
      
      public static Operation CreateOperation(Operation Opt) {
        
         Map<Integer,Operation> Operationes=new HashMap<Integer,Operation>(); //Integer for the ID;
         Operationes.put(Opt.getID(), Opt);
         
       OperationRef.setValue(Operationes);
       return Opt;
    }
      
      
 
      public static Operation updateOperation(Operation Opt) {
          
          DatabaseReference NewRef = OperationRef.child(String.valueOf(Opt.getID()));
        Map<String, Object> OptUpdates = new HashMap<String, Object >();
        OptUpdates.put(String.valueOf(Opt.getID()),Opt);
        NewRef.updateChildren(OptUpdates);
        return Opt;
    }
        
      
 
    public static Operation deleteOperation(String id) {
       
        DatabaseReference  DelRef= OperationRef.child(id);
        
        DelRef.removeValue();
        
    
    }  

    
      
}
