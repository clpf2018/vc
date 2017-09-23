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
 * Jersey REST client generated for REST resource:SupplierResource
 * [Supplier]<br>
 * USAGE:
 * <pre>
 *        supplierClient client = new supplierClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author mfaour
 */
@ManagedBean(name="supplierClient")
@ApplicationScoped
public class supplierClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/StockManagement.Services/webresources";

    public supplierClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("Supplier");
    }

    public <T> T add(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("add").request(javax.ws.rs.core.MediaType.TEXT_PLAIN).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T getAll(GenericType<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T addProduct(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("addProduct").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T updateProduct(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("updateProduct").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T get(Class<T> responseType, String supCode) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("code/{0}", new Object[]{supCode}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T update(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("update").request(javax.ws.rs.core.MediaType.TEXT_PLAIN).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T getProducts(Class<T> responseType, String supCode) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("products/{0}", new Object[]{supCode}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T delete(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("deleteById").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T deleteProduct(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("deleteProductById").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public void close() {
        client.close();
    }
    
}
