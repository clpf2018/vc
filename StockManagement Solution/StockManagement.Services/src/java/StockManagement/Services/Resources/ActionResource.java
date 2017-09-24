/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManagement.Services.Resources;

import StockManagement.ObjectModel.MangeObject.ActionController;
import StockManagement.ObjectModel.ObjectInterface.IAction;
import StockManagement.ObjectModel.ValueObject.*;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * 
 * @author ali chreif
 */
@Path("Action")
public class ActionResource {

    IAction _controller;

    public ActionResource() {
        _controller = new ActionController();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/code/{actCode}")
    public Action get(@PathParam("actCode") int actCode) {
        return _controller.get(actCode);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //@Path("/all")
    public List<Action> getAll() {
        return _controller.getAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/rolecode/{roCode}")
    public List<Action> getByRole(@PathParam("roCode") int roCode) {
        return _controller.getByRole(roCode);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/add")
    public int add(Action action) {
        return _controller.add(action);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/update")
    public boolean update(Action action) {
        return _controller.update(action);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/delete")
    public boolean delete(Action action) {
        return _controller.delete(action);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/deleteById")
    public boolean delete(int actCode) {
        return _controller.delete(actCode);
    }

}
