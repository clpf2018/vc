/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.access_webs;

import Inventory.Person;
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
class PersonService {
    
    FireBase_DataBase test;
    static DatabaseReference PersonRef;
   static  DatabaseReference ref;
   List<Person> Persones;
    
    PersonService() {
        try {
            this.test = new FireBase_DataBase();
             FirebaseDatabase database = FirebaseDatabase.getInstance();
             ref = database.getReference("");
             PersonRef = ref.child("Person");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PersonService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static List<Person> getAllPersones(){
        
    final List<Person> Persones=new ArrayList<Person>();    
        
// Attach a listener to read the data at our posts reference
PersonRef.addValueEventListener(new ValueEventListener() {
    
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        Person post = dataSnapshot.getValue(Person.class);
        Persones.add(post);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        System.out.println("The read failed: " + databaseError.getCode());
    }
});
        
return Persones;
    }
    
    
    
      public static Person getPersonForId(String id) {
        
          
            
    }
    
      
      
      
      
      
      public static Person CreatePerson(Person Per) {
        
         Map<Integer,Person> Persones=new HashMap<Integer,Person>(); //Integer for the ID;
         Persones.put(Per.getID(), Per);
         
       PersonRef.setValue(Persones);
       return Per;
    }
      
      
 
      public static Person updatePerson(Person Per) {
          
          DatabaseReference NewRef = PersonRef.child(String.valueOf(Per.getID()));
        Map<String, Object> PerUpdates = new HashMap<String, Object >();
        PerUpdates.put(String.valueOf(Per.getID()),Per);
        NewRef.updateChildren(PerUpdates);
        return Per;
    }
        
      
 
    public static Person deletePerson(String id) {
       
        DatabaseReference  DelRef= PersonRef.child(id);
        
        DelRef.removeValue();
        
    
    }  

    
      
}
