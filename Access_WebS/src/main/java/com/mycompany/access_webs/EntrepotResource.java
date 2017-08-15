package com.mycompany.access_webs;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author joseph
 */

import Inventory.Entrepot;
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


@Path("/Entrepot")
public class EntrepotResource {
    EntrepotService Warehouse=new EntrepotService();
    
    
    
     EntrepotService Address_Service = new EntrepotService();
 
    // CRUD -- CREATE operation
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Entrepot createWarehouse(Entrepot Entre) {
        Entrepot EntrepotResponse = EntrepotService.CreateWarehouse(Entre);
        return EntrepotResponse;
    }
    
    
    
    // CRUD -- READ operation
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Entrepot> getAllEntrepot() {
        List<Entrepot> EntrepotList = EntrepotService.getAllEntrepots();
        return EntrepotList;
    }
    
    
    
     // CRUD -- READ operation
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Entrepot getEntrepotForId(@PathParam("id") String id) {
        Entrepot Entre = EntrepotService.getEntrepotForId(id);
       
        return Entre;
    }
    
    
    
    
     // CRUD -- UPDATE operation
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Entrepot updateEntrepot(Entrepot Entre) {
        Entrepot EntrepotResponse = EntrepotService.updateEntrepot(Entre);
        return EntrepotResponse;
    }

    // CRUD -- DELETE operation
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Entrepot deleteEntrepot(@PathParam("id") String id) {
        Entrepot EntrepotResponse = EntrepotService.deleteEntrepot(id);
        return EntrepotResponse;
    }

    
    
    
    
    
    
    
    
}
