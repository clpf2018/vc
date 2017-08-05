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



import Inventory.Product_Category;
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

@Path("/Product_Category")
public class Product_CategoryResource {
    


    
    
    
     Product_CategoryService Product_Category_Service = new Product_CategoryService();
 
    // CRUD -- CREATE operation
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Product_Category createAddress(Product_Category Per) {
        Product_Category Product_CategoryResponse = Product_Category_Service.CreateProduct_Category(Per);
        return Product_CategoryResponse;
    }
    
    
    
    // CRUD -- READ operation
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product_Category> getAllProduct_Categorys() {
        List<Product_Category> Product_CategoryList = Product_Category_Service.getAllProduct_Categorys();
        return Product_CategoryList;
    }
    
    
    
     // CRUD -- READ operation
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product_Category getProduct_CategoryForId(@PathParam("id") String id) {
        Product_Category Per = Product_Category_Service.getProduct_CategoryForId(id);
       
        return Per;
    }
    
    
    
    
     // CRUD -- UPDATE operation
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Product_Category updateProduct_Category(Product_Category Per) {
        Product_Category Product_CategoryResponse = Product_Category_Service.updateProduct_Category(Per);
        return Product_CategoryResponse;
    }

    // CRUD -- DELETE operation
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product_Category deleteProduct_Category(@PathParam("id") String id) {
        Product_Category Product_CategoryResponse = Product_Category_Service.deleteProduct_Category(id);
        return Product_CategoryResponse;
    }




}
