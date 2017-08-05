/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.access_webs;

/**
 *
 * @author joseph
 */
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseCredentials;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 *
 * @author joseph
 */
public class FireBase_DataBase {
    
    
    
  
FileInputStream serviceAccount;

    public FireBase_DataBase() throws FileNotFoundException {
        this.serviceAccount = new FileInputStream("/home/joseph/NetBeansProjects/Access_WebS/JSON/gestion-et-suivi-de-bien-c2c12-firebase-adminsdk-3b0u0-fffb499f12.json");
    }
    
    
  


FirebaseOptions options = new FirebaseOptions.Builder()
  .setCredential(FirebaseCredentials.applicationDefault())
  .setDatabaseUrl("https://gestion-et-suivi-de-bien-c2c12.firebaseio.com/")
  .build();

//FirebaseApp.initializeApp(options);

//DatabaseReference ref = FirebaseDatabase
  //  .getInstance()
    //.getReference("");



}

