/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManamgement.Web.Beans;

import StockManagement.ObjectModel.ValueObject.Product;
import StockManagement.ObjectModel.ValueObject.Supplier;
import StockManagement.Services.productClient;
import StockManagement.Services.supplierClient;
import StockManamgement.Web.Utilities.MessageView;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author mfaour
 */
@ManagedBean
@ViewScoped
public class SupplierBean {

    @ManagedProperty("#{supplierClient}")
    private transient supplierClient service;
    private List<Supplier> suppliers;
    private Supplier selectedSupplier;
    private Supplier newSupplier;

    @PostConstruct
    public void init() {
        refreshData();
        newSupplier = new Supplier();
    }

    public void setService(supplierClient service) {
        this.service = service;
    }

    private void refreshData() {
        GenericType<List<Supplier>> gType = new GenericType<List<Supplier>>() {
        };
        suppliers = service.getAll(gType);
    }

    public List<Supplier> getSuppliers() {
        return suppliers;
    }

    /**
     * @return the selectedSupplier
     */
    public Supplier getSelectedSupplier() {
        return selectedSupplier;
    }

    /**
     * @param selectedSupplier the selectedSupplier to set
     */
    public void setSelectedSupplier(Supplier selectedSupplier) {
        this.selectedSupplier = selectedSupplier;
    }

    /**
     * @return the newSupplier
     */
    public Supplier getNewSupplier() {
        return newSupplier;
    }

    /**
     * @param newSupplier the newSupplier to set
     */
    public void setNewSupplier(Supplier newSupplier) {
        this.newSupplier = newSupplier;
    }

    
    public void add() {
        service.add(newSupplier, String.class);
        refreshData(); 
        MessageView.Info("Info", "Supplier saved successfully.");
    }
    public void update() {
        service.update(selectedSupplier, String.class);
        refreshData(); 
        MessageView.Info("Info", "Supplier updated successfully.");
    }
    
}
