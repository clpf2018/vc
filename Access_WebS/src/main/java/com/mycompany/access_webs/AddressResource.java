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

import Inventory.Address;
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


@Path("/Address")
public class AddressResource {
    
    
     AddressService AddressService = new AddressService();
 
    // CRUD -- CREATE operation
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Address createAddress(Address Addr) {
        Address AddressResponse = AddressService.CreateAddress(Addr);
        return AddressResponse;
    }
    
    
    
    // CRUD -- READ operation
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Address> getAllAddresses() {
        List<Address> AddressList = AddressService.getAllAddresses();
        return AddressList;
    }
    
    
    
     // CRUD -- READ operation
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Address getAddressForId(@PathParam("id") String id) {
        Address Addr = AddressService.getAddressForId(id);
       
        return Addr;
    }
    
    
    
    
     // CRUD -- UPDATE operation
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Address updateAddress(Address Addr) {
        Address AddressResponse = AddressService.updateAddress(Addr);
        return AddressResponse;
    }

    // CRUD -- DELETE operation
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Address deleteAddress(@PathParam("id") String id) {
        Address AddressResponse = AddressService.deleteAddress(id);
        return AddressResponse;
    }

    
    
    
    
    
    
    
    
}
