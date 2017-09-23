/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManamgement.Web.Beans;

import StockManagement.ObjectModel.ValueObject.Branch;
import StockManagement.ObjectModel.ValueObject.Company;
import StockManagement.ObjectModel.ValueObject.Role;
import StockManagement.ObjectModel.ValueObject.RoleBranch;
import StockManagement.Services.branchClient;
import StockManagement.Services.companyClient;
import StockManamgement.Web.Utilities.CustomBranchInfo;
import StockManamgement.Web.Utilities.MessageView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpSession;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.GenericType;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

/**
 *
 * @author mfaour
 */
@ManagedBean(name = "companyBean")
@ViewScoped
public class CompanyBean implements Serializable {

    private String compName;
    private String compDesc;

    private Branch newBranch;
    private Branch selectedBranch;
    private Company selectedCompany;
    private List<Company> companies;
    private List<Branch> branches;
    private DualListModel<Role> roles;
    private List<CustomBranchInfo> customBranches;
    @ManagedProperty("#{companyClient}")
    private transient companyClient service;

    // <editor-fold defaultstate="collapsed" desc="Company method">
    @PostConstruct
    public void init() {
        //service = new companyClient();
        refreshData();
        newBranch = new Branch();
        // selectedCompany = companies.get(0);
    }

    private void refreshData() {
        GenericType<List<Company>> gType = new GenericType<List<Company>>() {
        };
        companies = service.getAll(gType);
    }

    public void setService(companyClient service) {
        this.service = service;
    }

    public void add() {
        Company newC = new Company();
        newC.setCompName(getCompName());
        newC.setCompDesc(getCompDesc());
        newC.setCompStatus(1);
        service.add(newC, String.class);
        refreshData();
        MessageView.Info("Info", "Company saved successfully.");
        //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Company saved succesfully.."));
    }

    public void update() {
        service.update(selectedCompany, String.class);
        refreshData();
        MessageView.Info("Info", "Company updated successfully.");
    }

    public void delete() {
        service.delete(selectedCompany.getCompCode(), String.class);
        refreshData();
        MessageView.Info("Info", "Company " + selectedCompany.getCompName() + " deleted successfully.");
    }

    /**
     * @return the selectedCompany
     */
    public Company getSelectedCompany() {
        return selectedCompany;
    }

    /**
     * @param selectedCompany the selectedCompany to set
     */
    public void setSelectedCompany(Company selectedCompany) {
        this.selectedCompany = selectedCompany;
        HttpSession session = SessionUtils.getSession();
        session.setAttribute("SelectedCompany", selectedCompany);
    }

    /**
     * @return the companies
     */
    public List<Company> getCompanies() {
        return companies;
    }

    public String getCompName() {
        return compName;
    }

    /**
     * @param compName the compName to set
     */
    public void setCompName(String compName) {
        this.compName = compName;
    }

    /**
     * @return the compDesc
     */
    public String getCompDesc() {
        return compDesc;
    }

    /**
     * @param compDesc the compDesc to set
     */
    public void setCompDesc(String compDesc) {
        this.compDesc = compDesc;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Branch methods">
    /**
     * @return the companies
     */
    public List<Branch> getBranches() {
        return branches;
    }

    private void setBranches(List<Branch> branches) {
        this.branches = branches;
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

    public void onRowSelect(SelectEvent event) {
        Integer compCode = ((Company) event.getObject()).getCompCode();
        GenericType<List<Branch>> gType = new GenericType<List<Branch>>() {
        };
        branches = service.getBranches(gType, compCode.toString());

        if (null == branches || branches.isEmpty()) {
            return;
        }
        branchClient client = new branchClient();
        GenericType<List<Role>> roleType = new GenericType<List<Role>>() {
        };
        customBranches = new ArrayList();
        List<Role> includedRoles;
        List<Role> excludedRoles;
        for (Branch br : branches) {
            includedRoles = client.getRoles(roleType, br.getBrCode().toString());
            excludedRoles = client.getExcludedRoles(roleType, br.getBrCode().toString());
            CustomBranchInfo info = new CustomBranchInfo(br, includedRoles, excludedRoles);
            customBranches.add(info);
        }

        //roles = new DualListModel<>(includedRoles, excludedRoles);
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

    public void addBranch() {
        newBranch.setCompany(selectedCompany);
        service.addBranch(newBranch, String.class);
        MessageView.Info("Info", "Branch saved successfully.");
        //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Company saved succesfully.."));
    }

    public void updateBranch() {
        selectedBranch.setCompany(selectedCompany);
        service.updateBranch(selectedBranch, String.class);
        MessageView.Info("Info", "Branch updated successfully.");
    }

    public void deleteBranch() {
        service.deleteBranch(selectedBranch.getBrCode(), String.class);
        MessageView.Info("Info", "Branch deleted successfully.");
    }

    private DualListModel<String> cities;

    public DualListModel<String> getCities() {
        List<String> source = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            source.add("C" + i);
        }
        List<String> target = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            target.add("T" + i);
        }
        cities = new DualListModel<>(source, target);
        return cities;
    }

    public DualListModel<Role> getRoles() {
        if (null == selectedBranch
                || null == customBranches
                || customBranches.isEmpty()) {
            return null;
        }
        customBranches.stream().filter((custBr) -> (Objects.equals(custBr.getBranch().getBrCode(), selectedBranch.getBrCode()))).forEachOrdered((custBr) -> {
            roles = new DualListModel<>(custBr.getIncludedRoles(), custBr.getExcludedRoles());
        });
        return roles;
    }

    public void setRoles(DualListModel<Role> roles) {

        this.roles = roles;
    }

    public void onTransfer(TransferEvent event) {
        Role selectedRole;
        branchClient client = new branchClient();
        
            for (Object item : event.getItems()) {
                selectedRole = (Role) item;
                RoleBranch rb = new RoleBranch();
                rb.setBranch(selectedBranch);
                rb.setRole(selectedRole);
                if (!event.isAdd())//s->t
                    client.assignRole(rb, String.class);
                else
                    client.removeRole(rb, String.class);
            }
        

    }
    //</editor-fold>

}
