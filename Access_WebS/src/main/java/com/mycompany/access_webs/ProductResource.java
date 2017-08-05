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



import Inventory.Product;
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

@Path("/Product")
public class ProductResource {
    


    
    
    
     ProductService Product_Service = new ProductService();
 
    // CRUD -- CREATE operation
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Product createAddress(Product Per) {
        Product ProductResponse = Product_Service.CreateProduct(Per);
        return ProductResponse;
    }
    
    
    
    // CRUD -- READ operation
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getAllProducts() {
        List<Product> ProductList = Product_Service.getAllProducts();
        return ProductList;
    }
    
    
    
     // CRUD -- READ operation
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProductForId(@PathParam("id") String id) {
        Product Per = Product_Service.getProductForId(id);
       
        return Per;
    }
    
    
    
    
     // CRUD -- UPDATE operation
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Product updateProduct(Product Per) {
        Product ProductResponse = Product_Service.updateProduct(Per);
        return ProductResponse;
    }

    // CRUD -- DELETE operation
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product deleteProduct(@PathParam("id") String id) {
        Product ProductResponse = Product_Service.deleteProduct(id);
        return ProductResponse;
    }




}
