/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

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
    @WebMethod(operationName = "hello")
    @GET
    @Path("/hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "hello2")
    @GET
    @Path("/hello2")
    public String hello2(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
}
