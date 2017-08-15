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



import Inventory.Individual;
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

@Path("/Individual")
public class IndividualResource {
    


    
    
    
     IndividualService Individual_Service = new IndividualService();
 
    // CRUD -- CREATE operation
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Individual createAddress(Individual Per) {
        Individual IndividualResponse = Individual_Service.CreateIndividual(Per);
        return IndividualResponse;
    }
    
    
    
    // CRUD -- READ operation
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Individual> getAllIndividuals() {
        List<Individual> IndividualList = Individual_Service.getAllIndividuals();
        return IndividualList;
    }
    
    
    
     // CRUD -- READ operation
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Individual getIndividualForId(@PathParam("id") String id) {
        Individual Per = Individual_Service.getIndividualForId(id);
       
        return Per;
    }
    
    
    
    
     // CRUD -- UPDATE operation
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Individual updateIndividual(Individual Per) {
        Individual IndividualResponse = Individual_Service.updateIndividual(Per);
        return IndividualResponse;
    }

    // CRUD -- DELETE operation
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Individual deleteIndividual(@PathParam("id") String id) {
        Individual IndividualResponse = Individual_Service.deleteIndividual(id);
        return IndividualResponse;
    }




}
