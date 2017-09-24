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
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author MikeRmaily
 */
@ManagedBean(name = "brandBean")
@RequestScoped
public class BrandBean {

    private String BrandName;
    private Integer BrandCode;

    public String getBrandName() {
        return BrandName;
    }

    public void setBrandName(String BrandName) {
        this.BrandName = BrandName;
    }

    public Integer getBrandCode() {
        return BrandCode;
    }

    public void setBrandCode(Integer BrandCode) {
        this.BrandCode = BrandCode;
    }

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

        Brand newBrand = new Brand();
        newBrand.setBrdName(getBrandName());
        newBrand.setBrdCode(getBrandCode());
        newBrand.setBrdStatus(true);
        String localDate = null;
        java.util.Date date = java.sql.Date.valueOf(localDate);
        newBrand.setBrdCreationDate(date);
        service.add(newBrand, String.class);
        refreshData();
        MessageView.Info("Info", "Brand saved successfully.");
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
                HttpSession session = SessionUtils.getSession();
        session.setAttribute("selectedBrand", selectedBrand);
    }
    public void update() {
        service.update(selectedBrand, String.class);
        refreshData();
        MessageView.Info("Info", "Brand updated successfully.");
    }
    
        public void delete() {
        service.delete(selectedBrand.getBrdCode(), String.class);
        refreshData();
        MessageView.Info("Info", "Brand " + selectedBrand.getBrdName()+ " deleted successfully.");
    }

}
