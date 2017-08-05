/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.access_webs;

import Inventory.Entrepot;
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
class EntrepotService {
    
    FireBase_DataBase test;
    static DatabaseReference EntrepotRef;
   static  DatabaseReference ref;
   List<Entrepot> Entrepotes;
    
    EntrepotService() {
        try {
            this.test = new FireBase_DataBase();
             FirebaseDatabase database = FirebaseDatabase.getInstance();
             ref = database.getReference("");
             EntrepotRef = ref.child("Entrepot");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EntrepotService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static List<Entrepot> getAllEntrepotes(){
        
    final List<Entrepot> Entrepotes=new ArrayList<Entrepot>();    
        
// Attach a listener to read the data at our posts reference
EntrepotRef.addValueEventListener(new ValueEventListener() {
    
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        Entrepot post = dataSnapshot.getValue(Entrepot.class);
        Entrepotes.add(post);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        System.out.println("The read failed: " + databaseError.getCode());
    }
});
        
return Entrepotes;
    }
    
    
    
      public static Entrepot getEntrepotForId(String id) {
        
          
            
    }
    
      
      
      
      
      
      public static Entrepot CreateEntrepot(Entrepot Entre) {
        
         Map<Integer,Entrepot> Entrepotes=new HashMap<Integer,Entrepot>(); //Integer for the ID;
         Entrepotes.put(Entre.getID(), Entre);
         
       EntrepotRef.setValue(Entrepotes);
       return Entre;
    }
      
      
 
      public static Entrepot updateEntrepot(Entrepot Entre) {
          
          DatabaseReference NewRef = EntrepotRef.child(String.valueOf(Entre.getID()));
        Map<String, Object> EntreUpdates = new HashMap<String, Object >();
        EntreUpdates.put(String.valueOf(Entre.getID()),Entre);
        NewRef.updateChildren(EntreUpdates);
        return Entre;
    }
        
      
 
    public static Entrepot deleteEntrepot(String id) {
       
        DatabaseReference  DelRef= EntrepotRef.child(id);
        
        DelRef.removeValue();
        
    
    }  

    
      
}
