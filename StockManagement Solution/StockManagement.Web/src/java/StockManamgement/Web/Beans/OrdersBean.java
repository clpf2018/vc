/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManamgement.Web.Beans;

import StockManagement.ObjectModel.ValueObject.Company;
import StockManagement.ObjectModel.ValueObject.Order;
import StockManagement.ObjectModel.ValueObject.User;
import StockManagement.Services.companyClient;
import StockManagement.Services.orderClient;
import StockManagement.Services.userClient;
import StockManamgement.Web.Utilities.MessageView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.ws.rs.core.GenericType;
import org.primefaces.model.DualListModel;

/**
 * 
 * @author ali chreif
 */
@ManagedBean(name = "ordersBean")
@ViewScoped
public class OrdersBean implements Serializable {

    private int orderCode;
    private Date orderDate;
    private int orderSrc;
    private int orderDest;
    private int orderTrCode;
    private int orderQty;
    private int orderPrCode;
    private int orderCompCode;
    private int orderUsrCode;
    private int orderDbCr;

    public void setOrderCode(int orderCode) {
        this.orderCode = orderCode;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setOrderSrc(int orderSrc) {
        this.orderSrc = orderSrc;
    }

    public void setOrderDest(int orderDest) {
        this.orderDest = orderDest;
    }

    public void setOrderTrCode(int orderTrCode) {
        this.orderTrCode = orderTrCode;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }

    public void setOrderPrCode(int orderPrCode) {
        this.orderPrCode = orderPrCode;
    }

    public void setOrderCompCode(int orderCompCode) {
        this.orderCompCode = orderCompCode;
    }

    public void setOrderUsrCode(int orderUsrCode) {
        this.orderUsrCode = orderUsrCode;
    }

    public void setOrderDbCr(int orderDbCr) {
        this.orderDbCr = orderDbCr;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void setCities(DualListModel<String> cities) {
        this.cities = cities;
    }

    public int getOrderCode() {
        return orderCode;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public int getOrderSrc() {
        return orderSrc;
    }

    public int getOrderDest() {
        return orderDest;
    }

    public int getOrderTrCode() {
        return orderTrCode;
    }

    public int getOrderQty() {
        return orderQty;
    }

    public int getOrderPrCode() {
        return orderPrCode;
    }

    public int getOrderCompCode() {
        return orderCompCode;
    }

    public int getOrderUsrCode() {
        return orderUsrCode;
    }

    public int getOrderDbCr() {
        return orderDbCr;
    }
    private Order selectedOrder;
    private List<Order> orders;
    
    @ManagedProperty("#{orderClient}")
    private transient orderClient service;
    
    public void setSelectedOrder(Order selectedOrder) {
        this.selectedOrder = selectedOrder;
    }

    public Order getSelectedOrder() {
        return selectedOrder;
    }

    // <editor-fold defaultstate="collapsed" desc="Company method">
    @PostConstruct
    public void init() {
        //service = new companyClient();
        //add();
        refreshData();
        // selectedCompany = companies.get(0);
    }

    private void refreshData() {
        GenericType<List<Order>> gType = new GenericType<List<Order>>() {
        };

        orders = service.getByCompany(1, gType);
        int x = 1;
        int y = x;
    }

    public void setService(orderClient service) {
        this.service = service;
    }

    public void add() {  
        Order o = new Order();
        Company c = new Company();
        
        userClient client = new userClient();
        User u = client.get(User.class, 1);
        
        companyClient company = new companyClient();
        c = company.get(Company.class, "1");
        
        o.setCompany(c);
        o.setOrdCode(1);
        o.setOrdDate(new Date());
        o.setOrdDestination(2);
        o.setOrdQty(3);
        o.setOrdSource(1);
        o.setPrCode(2);
        o.setUser(u);
        
        service.add(o, int.class);
        
        /*newC.setOrdCode(getCompName());
        newC.setCompDesc(getCompDesc());
        newC.setCompStatus(1);
        service.add(newC, String.class);
        refreshData();
        MessageView.Info("Info", "Company saved successfully.");*/
        //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Company saved succesfully.."));
    }

    public void update() {
        service.update(selectedOrder, String.class);
        refreshData();
        MessageView.Info("Info", "Company updated successfully.");
    }

    public void delete() {
        service.delete(selectedOrder.getOrdCode(), String.class);
        refreshData();
        MessageView.Info("Info", "Company " + selectedOrder.getOrdCode() + " deleted successfully.");
    }

    /**
     * @return the companies
     */
    public List<Order> getOrders() {
        return orders;
    }

    
  

    /*public void onRowSelect(SelectEvent event) {
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
    }*/

   

   /* public void addBranch() {
        newBranch.setCompany(selectedCompany);
        service.addBranch(newBranch, String.class);
        MessageView.Info("Info", "Branch saved successfully.");
        //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Company saved succesfully.."));
    }*/

    /*public void updateBranch() {
        selectedBranch.setCompany(selectedCompany);
        service.updateBranch(selectedBranch, String.class);
        MessageView.Info("Info", "Branch updated successfully.");
    }*/


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

   


    /*public void onTransfer(TransferEvent event) {
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
        

    }*/
    //</editor-fold>

}
