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


import Inventory.Operation_type;
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


@Path("/Operation_type")
public class Operation_TypeResource {
    
    
    
      
    
    
     Operation_TypeService Operation_type_Service = new Operation_TypeService();
 
    // CRUD -- CREATE Operation_type
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Operation_type createAddress(Operation_type Loc) {
        Operation_type Operation_typeResponse = Operation_type_Service.CreateOperation_type(Loc);
        return Operation_typeResponse;
    }
    
    
    
    // CRUD -- READ Operation_type
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Operation_type> getAllOperation_types() {
        List<Operation_type> Operation_typeList = Operation_type_Service.getAllOperation_types();
        return Operation_typeList;
    }
    
    
    
     // CRUD -- READ Operation_type
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Operation_type getOperation_typeForId(@PathParam("id") String id) {
        Operation_type Loc = Operation_type_Service.getOperation_typeForId(id);
       
        return Loc;
    }
    
    
    
    
     // CRUD -- UPDATE Operation_type
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Operation_type updateOperation_type(Operation_type Loc) {
        Operation_type Operation_typeResponse = Operation_type_Service.updateOperation_type(Loc);
        return Operation_typeResponse;
    }

    // CRUD -- DELETE Operation_type
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Operation_type deleteOperation_type(@PathParam("id") String id) {
        Operation_type Operation_typeResponse = Operation_type_Service.deleteOperation_type(id);
        return Operation_typeResponse;
    }

    
    
    
    
    
    
    
    
}
