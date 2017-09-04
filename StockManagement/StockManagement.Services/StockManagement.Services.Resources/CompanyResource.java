/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManagement.Services.Resources;

import StockManagement.ObjectModel.MangeObject.*;
import StockManagement.ObjectModel.ValueObject.*;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.*;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Firas
 */
@Path("company")
public class CompanyResource {

    CompanyController _controller;

    /**
     * Creates a new instance of CompanyResource
     */
    public CompanyResource() {
_controller = new CompanyController();
    }

    /**
     * Retrieves representation of an instance of Services.CompanyResource
     *
     * @return an instance of StockManagement.ObjectModel.ValueObject.Company
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //@Path("/all")
    public List<Company> getAll() {
        List<Company> companies = _controller.getAll();
        return companies;
    }
     
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/stock/{compCode}")
    public Stock getStock(@PathParam("compCode") int compCode) {
        return _controller.getStock(compCode);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/code/{compCode}")
    public Company get(@PathParam("compCode") int compCode) {
        return _controller.get(compCode);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/add")
    public int add(Company company) {
        return _controller.add(company);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/update")
    public boolean update(Company company) {
        return _controller.update(company);
    }

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/delete")
    public boolean delete(int compCode) {
        return _controller.delete(compCode);
    }

  /*  @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/delete")
    public boolean delete(Company company) {
        return _controller.delete(company);
    }*/

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/addStock")
    public int addStock(Stock stock) {
        return _controller.addStock( stock);
    }

    /*@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/deleteStock")
    public boolean deleteStock(Stock stock) {
        return _controller.deleteStock(stock);
    }*/

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/deleteStockById")
    public boolean deleteStock(int stkCode) {
        return _controller.deleteStock(stkCode);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/updateStock")
    public boolean updateStock(Stock stock) {
        return _controller.updateStock(stock);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/addBranch")
    public int addBranch(Branch branch) {
        return _controller.addBranch(branch);
    }

    /*@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/deleteBranch")
    public boolean deleteBranch(Branch branch) {
        return _controller.deleteBranch(branch);
    }*/

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/deleteBranchById")
    public boolean deleteBranch(int brCode) {
        return _controller.deleteBranch(brCode);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/updateBranch")
    public boolean updateBranch(Branch branch) {
        return _controller.updateBranch(branch);
    }

   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/branches/{compCode}")
    public List<Branch> getBranches(@PathParam("compCode") int compCode) {
       /* List<Branch> branches = new ArrayList();
        Company c = new Company();
        c.setCompCode(21);
        c.setCompDesc("sds");
        c.setCompName("sads");
        for(int i=0;i<3;i++)
        {
            Branch b = new Branch();
            b.setCompany(c);
            b.setBrStatus(true);
            b.setBrAddress("adr"+i);
            b.setBrName("name"+i);
            b.setBrCode(i);
            branches.add(b);
        }*/
          
          List<Branch> branches = _controller.getBranches(compCode);
        if (branches == null || branches.isEmpty()) {
            return null;
        }
        List<Branch> newList = new ArrayList();
        for (int i = 0; i < branches.size(); i++) {
            Branch original = branches.get(i);
            Branch copy = new Branch();
            //copy.setCompany(original.getCompany());
            copy.setBrStatus(original.isBrStatus());
            copy.setBrAddress(original.getBrAddress());
            copy.setBrName(original.getBrName());
            copy.setBrCode(original.getBrCode());
            copy.setBrTel(original.getBrTel());
            newList.add(copy);

        }
        return newList;
        
        //return branches;
    }
     
}
