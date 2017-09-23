/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManamgement.Web.Beans;

import StockManagement.ObjectModel.ValueObject.Brand;
import StockManagement.Services.brandClient;
import StockManamgement.Web.Utilities.MessageView;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author MikeRmaily
 */
@ManagedBean(name = "brandBean")
@RequestScoped
public class BrandBean {

    private Brand newBrand;

    private Brand selectedBrand;
    private List<Brand> brands;

    @ManagedProperty("#{brandClient}")
    private brandClient service;

    @PostConstruct
    public void init() {
        refreshData();
    }

    private void refreshData() {
        GenericType<List<Brand>> gType = new GenericType<List<Brand>>() {
        };
        brands = service.getAll(gType);
    }

    public void setService(brandClient service) {
        this.service = service;
    }

    public void add() {

        service.add(newBrand, String.class);
        refreshData();
        MessageView.Info("Info", "Brand saved successfully.");
        //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Company saved succesfully.."));
    }

    /**
     * @return the companies
     */
    public List<Brand> getBrands() {
        return brands;
    }

    /**
     * @return the selectedBrand
     */
    public Brand getSelectedBrand() {
        return selectedBrand;
    }

    /**
     * @param selectedBrand the selectedBrand to set
     */
    public void setSelectedBrand(Brand selectedBrand) {
        this.selectedBrand = selectedBrand;
    }

    /**
     * @return the newBrand
     */
    public Brand getNewBrand() {
        return newBrand;
    }

    /**
     * @param newBrand the newBrand to set
     */
    public void setNewBrand(Brand newBrand) {
        this.newBrand = newBrand;
    }

}
