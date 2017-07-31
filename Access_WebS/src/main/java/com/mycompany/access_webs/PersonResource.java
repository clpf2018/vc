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



import Inventory.Person;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/Person")
public class PersonResource {
    


    
    
    
     PersonService Person_Service = new PersonService();
 
    // CRUD -- CREATE operation
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Person createAddress(Person Per) {
        Person PersonResponse = Person_Service.CreatePerson(Per);
        return PersonResponse;
    }
    
    
    
    // CRUD -- READ operation
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAllPersons() {
        List<Person> PersonList = Person_Service.getAllPersons();
        return PersonList;
    }
    
    
    
     // CRUD -- READ operation
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonForId(@PathParam("id") String id) {
        Person Per = Person_Service.getPersonForId(id);
       
        return Per;
    }
    
    
    
    
     // CRUD -- UPDATE operation
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Person updatePerson(Person Per) {
        Person PersonResponse = Person_Service.updatePerson(Per);
        return PersonResponse;
    }

    // CRUD -- DELETE operation
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person deletePerson(@PathParam("id") String id) {
        Person PersonResponse = Person_Service.deletePerson(id);
        return PersonResponse;
    }




}
