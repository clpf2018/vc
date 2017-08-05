/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.access_webs;

import Inventory.Location;
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
class LocationService {
    
    FireBase_DataBase test;
    static DatabaseReference LocationRef;
   static  DatabaseReference ref;
   List<Location> Locationes;
    
    LocationService() {
        try {
            this.test = new FireBase_DataBase();
             FirebaseDatabase database = FirebaseDatabase.getInstance();
             ref = database.getReference("");
             LocationRef = ref.child("Location");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LocationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static List<Location> getAllLocationes(){
        
    final List<Location> Locationes=new ArrayList<Location>();    
        
// Attach a listener to read the data at our posts reference
LocationRef.addValueEventListener(new ValueEventListener() {
    
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        Location post = dataSnapshot.getValue(Location.class);
        Locationes.add(post);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        System.out.println("The read failed: " + databaseError.getCode());
    }
});
        
return Locationes;
    }
    
    
    
      public static Location getLocationForId(String id) {
        
          
            
    }
    
      
      
      
      
      
      public static Location CreateLocation(Location Loc) {
        
         Map<Integer,Location> Locationes=new HashMap<Integer,Location>(); //Integer for the ID;
         Locationes.put(Loc.getID(), Loc);
         
       LocationRef.setValue(Locationes);
       return Loc;
    }
      
      
 
      public static Location updateLocation(Location Loc) {
          
          DatabaseReference NewRef = LocationRef.child(String.valueOf(Loc.getID()));
        Map<String, Object> LocUpdates = new HashMap<String, Object >();
        LocUpdates.put(String.valueOf(Loc.getID()),Loc);
        NewRef.updateChildren(LocUpdates);
        return Loc;
    }
        
      
 
    public static Location deleteLocation(String id) {
       
        DatabaseReference  DelRef= LocationRef.child(id);
        
        DelRef.removeValue();
        
    
    }  

    
      
}
