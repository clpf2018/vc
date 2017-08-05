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


import Inventory.Operation_State;
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


@Path("/Operation_State")
public class Operation_StateResource {
    
    
    
      
    
    
     Operation_StateService Operation_State_Service = new Operation_StateService();
 
    // CRUD -- CREATE Operation_State
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Operation_State createAddress(Operation_State Loc) {
        Operation_State Operation_StateResponse = Operation_State_Service.CreateOperation_State(Loc);
        return Operation_StateResponse;
    }
    
    
    
    // CRUD -- READ Operation_State
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Operation_State> getAllOperation_States() {
        List<Operation_State> Operation_StateList = Operation_State_Service.getAllOperation_States();
        return Operation_StateList;
    }
    
    
    
     // CRUD -- READ Operation_State
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Operation_State getOperation_StateForId(@PathParam("id") String id) {
        Operation_State Loc = Operation_State_Service.getOperation_StateForId(id);
       
        return Loc;
    }
    
    
    
    
     // CRUD -- UPDATE Operation_State
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Operation_State updateOperation_State(Operation_State Loc) {
        Operation_State Operation_StateResponse = Operation_State_Service.updateOperation_State(Loc);
        return Operation_StateResponse;
    }

    // CRUD -- DELETE Operation_State
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Operation_State deleteOperation_State(@PathParam("id") String id) {
        Operation_State Operation_StateResponse = Operation_State_Service.deleteOperation_State(id);
        return Operation_StateResponse;
    }

    
    
    
    
    
    
    
    
}
