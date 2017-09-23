/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManamgement.Web.Beans;

import StockManagement.ObjectModel.ValueObject.Branch;
import StockManagement.ObjectModel.ValueObject.Company;
import StockManagement.Services.companyClient;
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
 * @author mfaour
 */
@ManagedBean(name = "branchBean")
@RequestScoped
public class BranchBean {

    private Branch newBranch;

    private Branch selectedBranch;
    private List<Branch> branches;

    @ManagedProperty("#{companyClient}")
    private companyClient service;


    private Company getSelectedCompany() {
        return SessionUtils.getSelectedCompany();
    }

    @PostConstruct
    public void init() {
        refreshData();
    }

    private void refreshData() {
        GenericType<List<Branch>> gType = new GenericType<List<Branch>>() {
        };
        branches = service.getBranches(gType, getSelectedCompany().getCompCode().toString());
    }

    public void setService(companyClient service) {
        this.service = service;
    }

    public void add() {
        newBranch.setCompany(getSelectedCompany());

        service.addBranch(newBranch, String.class);
        refreshData();
        MessageView.Info("Info", "Branch saved successfully.");
        //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Company saved succesfully.."));
    }

    /**
     * @return the companies
     */
    public List<Branch> getBranches() {
        return branches;
    }

    /**
     * @return the selectedBranch
     */
    public Branch getSelectedBranch() {
        return selectedBranch;
    }

    /**
     * @param selectedBranch the selectedBranch to set
     */
    public void setSelectedBranch(Branch selectedBranch) {
        this.selectedBranch = selectedBranch;
    }

    /**
     * @return the newBranch
     */
    public Branch getNewBranch() {
        return newBranch;
    }

    /**
     * @param newBranch the newBranch to set
     */
    public void setNewBranch(Branch newBranch) {
        this.newBranch = newBranch;
    }

}
