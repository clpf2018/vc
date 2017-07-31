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

import Inventory.Localization;
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

@Path("/Localization")
public class LocalizationRessource {
    
    
     
    
    
     LocalizationService Localization_Service = new LocalizationService();
 
    // CRUD -- CREATE operation
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Localization createAddress(Localization Loc) {
        Localization LocalizationResponse = Localization_Service.CreateLocalization(Loc);
        return LocalizationResponse;
    }
    
    
    
    // CRUD -- READ operation
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Localization> getAllLocalizations() {
        List<Localization> LocalizationList = Localization_Service.getAllLocalizations();
        return LocalizationList;
    }
    
    
    
     // CRUD -- READ operation
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Localization getLocalizationForId(@PathParam("id") String id) {
        Localization Loc = Localization_Service.getLocalizationForId(id);
       
        return Loc;
    }
    
    
    
    
     // CRUD -- UPDATE operation
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Localization updateLocalization(Localization Loc) {
        Localization LocalizationResponse = Localization_Service.updateLocalization(Loc);
        return LocalizationResponse;
    }

    // CRUD -- DELETE operation
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Localization deleteLocalization(@PathParam("id") String id) {
        Localization LocalizationResponse = Localization_Service.deleteLocalization(id);
        return LocalizationResponse;
    }


    
}
