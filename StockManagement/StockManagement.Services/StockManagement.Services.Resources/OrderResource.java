/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManagement.Services.Resources;

import StockManagement.ObjectModel.MangeObject.OrderController;
import StockManagement.ObjectModel.ObjectInterface.IOrder;
import StockManagement.ObjectModel.ValueObject.*;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author mfaour
 */
@Path("Order")
public class OrderResource {

    IOrder _controller;

    public OrderResource() {
        _controller = new OrderController();
    }
    
 
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/add")
    public int add(Order order) {
        return _controller.add(order);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/update")
    public boolean update(Order order) {
        return _controller.update(order);
    }


    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/delete")
    public boolean delete(Order order) {
        return _controller.delete(order);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/deleteById")
    public boolean delete(int ordCode) {
        return _controller.delete(ordCode);
    }

  @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getBySource")
    public List<Order> getBySource(OrderRoute orderRoute) {
        return _controller.getBySource(orderRoute);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getByDestination")
    public List<Order> getByDestination(OrderRoute orderRoute) {
        return _controller.getByDestination(orderRoute);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/getByCompany/{compCode}")
    public List<Order> getByCompany(@PathParam("compCode") int compCode) {
        return _controller.getByCompany(compCode);
    }

     @GET
    @Produces(MediaType.APPLICATION_JSON)
     
    public List<Order> getAll() {
        return null;
        // throw (new Exception("Not implemented exception"));
    }
    
}
