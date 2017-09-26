/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManamgement.Web.Beans;

import StockManagement.ObjectModel.ValueObject.Client;
import StockManagement.Services.customerClient;
import StockManamgement.Web.Utilities.MessageView;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author Chiraze Haidar
 */
@ManagedBean
@ViewScoped
public class ClientBean 
{
    @ManagedProperty("#{customerClient}")
    private transient customerClient service;
    private List<Client> clients;
    private Client selectedClient;
    private Client newClient;

    @PostConstruct
    public void init() 
    {
        refreshData();
        newClient = new Client();
    }

    public void setService(customerClient service) 
    {
        this.service = service;
    }

    private void refreshData() 
    {
        GenericType<List<Client>> gType = new GenericType<List<Client>>(){};
        clients = service.getAll(gType);
    }

    public List<Client> getClients() 
    {
        return clients;
    }

    /**
     * @return the selectedClient
     */
    public Client getSelectedClient() 
    {
        return selectedClient;
    }

    /**
     * @param selectedClient the selectedClient to set
     */
    public void setSelectedClient(Client selectedClient) 
    {
        this.selectedClient = selectedClient;
    }

    /**
     * @return the newClient
     */
    public Client getNewClient() 
    {
        return newClient;
    }

    /**
     * @param newClient the newClient to set
     */
    public void setNewClient(Client newClient) 
    {
        this.newClient = newClient;
    }

    public void add() 
    {
        Date date = new Date();
        newClient.setCltCreationDate(date);
        service.add(newClient, String.class);
        refreshData();
        MessageView.Info("Info", "Client saved successfully.");
    }

    public void update() 
    {
        service.update(selectedClient, String.class);
        refreshData();
        MessageView.Info("Info", "Client updated successfully.");
    }

     public void delete() 
     {
        service.delete(selectedClient, String.class);
        refreshData();
        MessageView.Info("Info", "Client deleted successfully.");
    }
}
