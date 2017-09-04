/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManagement.Services.Resources;

import StockManagement.ObjectModel.MangeObject.ProductController;
import StockManagement.ObjectModel.ValueObject.Product;
import StockManagement.ObjectModel.ObjectInterface.IProduct;
import StockManagement.ObjectModel.Utilities.StatusEnum;
import StockManagement.ObjectModel.ValueObject.BranchProduct;
import StockManagement.ObjectModel.ValueObject.StockProduct;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author mfaour
 */
@Path("Product")
public class ProductResource {

    IProduct _controller;

    public ProductResource() {
        _controller = new ProductController();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getAll() {
        return null;
        // throw (new Exception("Not implemented exception"));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/code/{prCode}")
    public Product get(@PathParam("prCode") int prCode) {
        return _controller.get(prCode);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getByBarcode/{prBarcode}")
    public Product getByBarcode(@PathParam("prBarcode") String prBarcode) {
        return _controller.getByBarcode(prBarcode);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getByType/{prType}")
    public List<Product> getByType(@PathParam("prType") int prType) {
        return _controller.getByType(prType);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all/{status}")
    public List<Product> getAll(@PathParam("status") StatusEnum status) {
        return _controller.getAll(status);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getBySupplier/{supCode}")
    public List<Product> getBySupplier(@PathParam("supCode") int supCode) {
        return _controller.getBySupplier(supCode);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getByBrand/{brdCode}")
    public List<Product> getByBrand(@PathParam("brdCode") int brdCode) {
        return _controller.getByBrand(brdCode);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getByBranch/{brCode}")
    public List<Product> getByBranch(@PathParam("brCode") int brCode) {
        return _controller.getByBranch(brCode);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/add")
    public int add(Product product) {
        return _controller.add(product);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/addToStock")
    public boolean addToStock(StockProduct stockProduct) {
        return _controller.addToStock(stockProduct);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/addToBranch")
    public boolean addToBranch(BranchProduct branchProduct) {
        return _controller.addToBranch(branchProduct);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/delete")
    public boolean delete(Product product) {
        return _controller.delete(product);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/deleteById")
    public boolean delete(int prCode) {
        return _controller.delete(prCode);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/update")
    public boolean update(Product product) {
        return _controller.update(product);
    }

}
