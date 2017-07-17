/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import Inventory.Address;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
/**
 *
 * @author mohamad
 */
@WebService(serviceName = "TestService")
@Path("/testService")
public class TestService { 
    /**
     * This is a sample web service operation
     */
    private Address testAdress;
    @WebMethod(operationName = "hello")
    @GET
    @Path("/hello")
    public String hello(@WebParam(name = "name") String txt) {
        testAdress=new Address(0, txt, txt, txt, 0, txt, txt, txt, txt);
        return "Hello " + txt + " !";
    }
}
