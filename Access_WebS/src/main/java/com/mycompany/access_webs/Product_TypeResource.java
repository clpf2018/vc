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



import Inventory.Product_Type;
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

@Path("/Product_Type")
public class Product_TypeResource {
    


    
    
    
     Product_TypeService Product_Type_Service = new Product_TypeService();
 
    // CRUD -- CREATE operation
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Product_Type createAddress(Product_Type Per) {
        Product_Type Product_TypeResponse = Product_Type_Service.CreateProduct_Type(Per);
        return Product_TypeResponse;
    }
    
    
    
    // CRUD -- READ operation
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product_Type> getAllProduct_Types() {
        List<Product_Type> Product_TypeList = Product_Type_Service.getAllProduct_Types();
        return Product_TypeList;
    }
    
    
    
     // CRUD -- READ operation
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product_Type getProduct_TypeForId(@PathParam("id") String id) {
        Product_Type Per = Product_Type_Service.getProduct_TypeForId(id);
       
        return Per;
    }
    
    
    
    
     // CRUD -- UPDATE operation
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Product_Type updateProduct_Type(Product_Type Per) {
        Product_Type Product_TypeResponse = Product_Type_Service.updateProduct_Type(Per);
        return Product_TypeResponse;
    }

    // CRUD -- DELETE operation
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product_Type deleteProduct_Type(@PathParam("id") String id) {
        Product_Type Product_TypeResponse = Product_Type_Service.deleteProduct_Type(id);
        return Product_TypeResponse;
    }




}
