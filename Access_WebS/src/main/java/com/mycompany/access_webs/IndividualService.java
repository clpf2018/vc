/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.access_webs;

import Inventory.Individual;
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
class IndividualService {
    
    FireBase_DataBase test;
    static DatabaseReference IndividualRef;
   static  DatabaseReference ref;
   List<Individual> Individuales;
    
    IndividualService() {
        try {
            this.test = new FireBase_DataBase();
             FirebaseDatabase database = FirebaseDatabase.getInstance();
             ref = database.getReference("");
             IndividualRef = ref.child("Individual");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IndividualService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static List<Individual> getAllIndividuales(){
        
    final List<Individual> Individuales=new ArrayList<Individual>();    
        
// Attach a listener to read the data at our posts reference
IndividualRef.addValueEventListener(new ValueEventListener() {
    
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        Individual post = dataSnapshot.getValue(Individual.class);
        Individuales.add(post);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        System.out.println("The read failed: " + databaseError.getCode());
    }
});
        
return Individuales;
    }
    
    
    
      public static Individual getIndividualForId(String id) {
        
          
            
    }
    
      
      
      
      
      
      public static Individual CreateIndividual(Individual Per) {
        
         Map<Integer,Individual> Individuales=new HashMap<Integer,Individual>(); //Integer for the ID;
         Individuales.put(Per.getID(), Per);
         
       IndividualRef.setValue(Individuales);
       return Per;
    }
      
      
 
      public static Individual updateIndividual(Individual Per) {
          
          DatabaseReference NewRef = IndividualRef.child(String.valueOf(Per.getID()));
        Map<String, Object> PerUpdates = new HashMap<String, Object >();
        PerUpdates.put(String.valueOf(Per.getID()),Per);
        NewRef.updateChildren(PerUpdates);
        return Per;
    }
        
      
 
    public static Individual deleteIndividual(String id) {
       
        DatabaseReference  DelRef= IndividualRef.child(id);
        
        DelRef.removeValue();
        
    
    }  

    
      
}
