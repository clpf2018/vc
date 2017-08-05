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


import Inventory.Operation;
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


@Path("/Operation")
public class OperationResource {
    
    
    
      
    
    
     OperationService Operation_Service = new OperationService();
 
    // CRUD -- CREATE operation
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Operation createAddress(Operation Loc) {
        Operation OperationResponse = Operation_Service.CreateOperation(Loc);
        return OperationResponse;
    }
    
    
    
    // CRUD -- READ operation
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Operation> getAllOperations() {
        List<Operation> OperationList = Operation_Service.getAllOperations();
        return OperationList;
    }
    
    
    
     // CRUD -- READ operation
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Operation getOperationForId(@PathParam("id") String id) {
        Operation Loc = Operation_Service.getOperationForId(id);
       
        return Loc;
    }
    
    
    
    
     // CRUD -- UPDATE operation
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Operation updateOperation(Operation Loc) {
        Operation OperationResponse = Operation_Service.updateOperation(Loc);
        return OperationResponse;
    }

    // CRUD -- DELETE operation
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Operation deleteOperation(@PathParam("id") String id) {
        Operation OperationResponse = Operation_Service.deleteOperation(id);
        return OperationResponse;
    }

    
    
    
    
    
    
    
    
}
