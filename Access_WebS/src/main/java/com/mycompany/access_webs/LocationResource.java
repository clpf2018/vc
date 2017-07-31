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


import Inventory.Location;
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


@Path("/Location")
public class LocationResource {
    
    
    
      
    
    
     LocationService Location_Service = new LocationService();
 
    // CRUD -- CREATE operation
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Location createAddress(Location Loc) {
        Location LocationResponse = Location_Service.CreateLocation(Loc);
        return LocationResponse;
    }
    
    
    
    // CRUD -- READ operation
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Location> getAllLocations() {
        List<Location> LocationList = Location_Service.getAllLocations();
        return LocationList;
    }
    
    
    
     // CRUD -- READ operation
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Location getLocationForId(@PathParam("id") String id) {
        Location Loc = Location_Service.getLocationForId(id);
       
        return Loc;
    }
    
    
    
    
     // CRUD -- UPDATE operation
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Location updateLocation(Location Loc) {
        Location LocationResponse = Location_Service.updateLocation(Loc);
        return LocationResponse;
    }

    // CRUD -- DELETE operation
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Location deleteLocation(@PathParam("id") String id) {
        Location LocationResponse = Location_Service.deleteLocation(id);
        return LocationResponse;
    }

    
    
    
    
    
    
    
    
}
