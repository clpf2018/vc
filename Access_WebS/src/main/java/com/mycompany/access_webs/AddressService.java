/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.access_webs;

import Inventory.Address;
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
class AddressService {
    
    FireBase_DataBase test;
    static DatabaseReference AddressRef;
   static  DatabaseReference ref;
   List<Address> Addresses;
    
    AddressService() {
        try {
            this.test = new FireBase_DataBase();
             FirebaseDatabase database = FirebaseDatabase.getInstance();
             ref = database.getReference("");
             AddressRef = ref.child("Address");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddressService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static List<Address> getAllAddresses(){
        
    final List<Address> Addresses=new ArrayList<Address>();    
        
// Attach a listener to read the data at our posts reference
AddressRef.addValueEventListener(new ValueEventListener() {
    
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        Address post = dataSnapshot.getValue(Address.class);
        Addresses.add(post);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        System.out.println("The read failed: " + databaseError.getCode());
    }
});
        
return Addresses;
    }
    
    
    
      public static Address getAddressForId(String id) {
        
          
            
    }
    
      
      
      
      
      
      public static Address CreateAddress(Address Addr) {
        
         Map<Integer,Address> Addresses=new HashMap<Integer,Address>(); //Integer for the ID;
         Addresses.put(Addr.getID(), Addr);
         
       AddressRef.setValue(Addresses);
       return Addr;
    }
      
      
 
      public static Address updateAddress(Address Addr) {
          
          DatabaseReference NewRef = AddressRef.child(String.valueOf(Addr.getID()));
        Map<String, Object> AddrUpdates = new HashMap<String, Object >();
        AddrUpdates.put(String.valueOf(Addr.getID()),Addr);
        NewRef.updateChildren(AddrUpdates);
        return Addr;
    }
        
      
 
    public static Address deleteAddress(String id) {
       
        DatabaseReference  DelRef= AddressRef.child(id);
        
        DelRef.removeValue();
        
    
    }  

    
      
}
