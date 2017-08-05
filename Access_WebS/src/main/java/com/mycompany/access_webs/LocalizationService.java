/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.access_webs;

import Inventory.Localization;
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
class LocalizationService {
    
    FireBase_DataBase test;
    static DatabaseReference LocalizationRef;
   static  DatabaseReference ref;
   List<Localization> Localizationes;
    
    LocalizationService() {
        try {
            this.test = new FireBase_DataBase();
             FirebaseDatabase database = FirebaseDatabase.getInstance();
             ref = database.getReference("");
             LocalizationRef = ref.child("Localization");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LocalizationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static List<Localization> getAllLocalizationes(){
        
    final List<Localization> Localizationes=new ArrayList<Localization>();    
        
// Attach a listener to read the data at our posts reference
LocalizationRef.addValueEventListener(new ValueEventListener() {
    
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        Localization post = dataSnapshot.getValue(Localization.class);
        Localizationes.add(post);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        System.out.println("The read failed: " + databaseError.getCode());
    }
});
        
return Localizationes;
    }
    
    
    
      public static Localization getLocalizationForId(String id) {
        
          
            
    }
    
      
      
      
      
      
      public static Localization CreateLocalization(Localization Loc) {
        
         Map<Integer,Localization> Localizationes=new HashMap<Integer,Localization>(); //Integer for the ID;
         Localizationes.put(Loc.getID(), Loc);
         
       LocalizationRef.setValue(Localizationes);
       return Loc;
    }
      
      
 
      public static Localization updateLocalization(Localization Loc) {
          
          DatabaseReference NewRef = LocalizationRef.child(String.valueOf(Loc.getID()));
        Map<String, Object> LocUpdates = new HashMap<String, Object >();
        LocUpdates.put(String.valueOf(Loc.getID()),Loc);
        NewRef.updateChildren(LocUpdates);
        return Loc;
    }
        
      
 
    public static Localization deleteLocalization(String id) {
       
        DatabaseReference  DelRef= LocalizationRef.child(id);
        
        DelRef.removeValue();
        
    
    }  

    
      
}
