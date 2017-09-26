/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManagement.Services.Resources;

import StockManagement.ObjectModel.MangeObject.ClientController;
import StockManagement.ObjectModel.ObjectInterface.IClient;
import StockManagement.ObjectModel.ValueObject.Client;
import StockManagement.ObjectModel.ValueObject.Order;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Chiraze Haidar
 */

@Path("Client")
public class ClientResource 
{

    IClient _controller;

    public ClientResource() 
    {
        _controller = new ClientController();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //@Path("/all")
    public List<Client> getAll() 
    {
        return _controller.getAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)

    @Path("/code/{cltCode}")
    public Client get(@PathParam("cltCode") int cltCode) 
    {
        return _controller.get(cltCode);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/add")
    public int add(Client client) 
    {
        return _controller.add(client);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/update")
    public boolean update(Client client) 
    {
        return _controller.update(client);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/delete")
    public boolean delete(Client client) 
    {
        return _controller.delete(client);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/deleteById")
    public boolean delete(int cltCode) 
    {
        return _controller.delete(cltCode);
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/orders/{cltCode}")
    public List<Order> getOrders(@PathParam("cltCode") int cltCode) 
    {
        return _controller.getOrders(cltCode);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/attachOrder")
    public int addOrder(Order order) 
    {
        return _controller.addOrder(order);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/sendMessage")
    public boolean sendMessage(Client client) 
    {
        return _controller.sendMessage(client);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/sendCatalog")
    public boolean sendCatalog(Client client) 
    {
        return _controller.sendCatalog(client);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/sendMessageById")
    public boolean sendMessage(int cltCode) 
    {
        return _controller.sendMessage(cltCode);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/sendCatalogById")
    public boolean sendCatalog(int cltCode) 
    {
        return _controller.sendCatalog(cltCode);
    }

}
