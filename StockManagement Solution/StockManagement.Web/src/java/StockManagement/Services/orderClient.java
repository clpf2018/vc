/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManagement.Services;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

/**
 * 
 * @author ali chreif
 * order client   
 */
@ManagedBean(name="orderClient")
@ApplicationScoped
public class orderClient {

    private final WebTarget webTarget;
    private final Client client;
    private static final String BASE_URI = "http://35.194.131.184:8090/StockManagement.Services/webresources";

    public orderClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("Order");
    }

    public <T> T add(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("add").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T deleteBranch(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("deleteBranchById").request(javax.ws.rs.core.MediaType.TEXT_PLAIN).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.TEXT_PLAIN), responseType);
    }

    public <T> T getAll(GenericType<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }
    
    public <T> T getByCompany(Object requestEntity,GenericType<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }
    

    public <T> T updateStock(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("updateStock").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T addBranch(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("addBranch").request(javax.ws.rs.core.MediaType.TEXT_PLAIN).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T updateBranch(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("updateBranch").request(javax.ws.rs.core.MediaType.TEXT_PLAIN).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T getStock(Class<T> responseType, String compCode) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("stock/{0}", new Object[]{compCode}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T update(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("update").request(javax.ws.rs.core.MediaType.TEXT_PLAIN).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T delete(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("delete").request(javax.ws.rs.core.MediaType.TEXT_PLAIN).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.TEXT_PLAIN), responseType);
    }

    public <T> T getBranches(GenericType<T> responseType, String compCode) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("branches/{0}", new Object[]{compCode}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    } 

    public <T> T deleteStock(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("deleteStockById").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T get(Class<T> responseType, String compCode) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("code/{0}", new Object[]{compCode}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T addStock(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("addStock").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public void close() {
        client.close();
    }
    
}
