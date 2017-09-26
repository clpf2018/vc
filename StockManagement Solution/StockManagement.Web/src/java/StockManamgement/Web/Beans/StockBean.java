/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManamgement.Web.Beans;

import StockManagement.ObjectModel.ValueObject.Product;
import StockManagement.ObjectModel.ValueObject.Stock;
import StockManagement.ObjectModel.ValueObject.StockProduct;
import StockManagement.ObjectModel.ValueObject.Supplier;
import StockManagement.Services.companyClient;
import StockManagement.Services.productClient;
import StockManamgement.Web.Utilities.MessageView;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author mfaour
 */
@ManagedBean(name = "stockBean")
@ViewScoped
public class StockBean implements Serializable {

    private List<Product> products;
    private Product selectedProduct;
    @ManagedProperty("#{productClient}")
    private transient productClient service;
    private List<Supplier> suppliers;
    private List<Product> supplierProducts;
    private int qunatity;
    private String stockCode;
    private int supCode;
    private int prCode;
    private String stkCode;
    @PostConstruct
    public void init() {
         
        
        refreshData();
        GenericType<List<Supplier>> gType = new GenericType<List<Supplier>>() {
        };

        suppliers = service.getAllSuppliers(gType);
    }

    public void setService(productClient service) {
        this.service = service;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedCompany(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    private void refreshData() {
        GenericType<List<Product>> gType = new GenericType<List<Product>>() {
        };
       Map<String, String> params = FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap();
        if (stkCode == null || stkCode.isEmpty()) {
            companyClient client = new companyClient();
            stkCode = params.get("comp_id");
            Stock stock = client.getStock(Stock.class, stkCode);
            if ( stock == null)
            {
                MessageView.Error("Error", "Company does not have a stock yet..");
                return;
            }
            stkCode = String.valueOf( stock.getStkCode());
        }
        products = service.getByStock(gType, stkCode);
    }

    public List<Supplier> getSuppliers() {
        return suppliers;
    }

    public void onSupplierChange() {
        GenericType<List<Product>> gType = new GenericType<List<Product>>() {
        };
        supplierProducts = service.getBySupplier(gType, String.valueOf(supCode));
    }

    /**
     * @return the supplierProducts
     */
    public List<Product> getSupplierProducts() {
        return supplierProducts;
    }

    /**
     * @param supplierProducts the supplierProducts to set
     */
    public void setSupplierProducts(List<Product> supplierProducts) {
        this.supplierProducts = supplierProducts;
    }

    /**
     * @return the supCode
     */
    public int getSupCode() {
        return supCode;
    }

    /**
     * @param supCode the supCode to set
     */
    public void setSupCode(int supCode) {
        this.supCode = supCode;
    }

    /**
     * @return the qunatity
     */
    public int getQunatity() {
        return qunatity;
    }

    /**
     * @param qunatity the qunatity to set
     */
    public void setQunatity(int qunatity) {
        this.qunatity = qunatity;
    }

    public void addToStock() {
        StockProduct sp = new StockProduct();
        sp.setStkPrQty(qunatity);

        Product product = service.get(Product.class, String.valueOf(prCode));
        sp.setProduct(product);
        
        Stock stk = service.getStock(Stock.class, stockCode);
        sp.setStock(stk);
        
        service.addToStock(sp, String.class);
        MessageView.Info("Info", "Product added successfully.");
        refreshData();

    }

   
    /**
     * @return the prCode
     */
    public int getPrCode() {
        return prCode;
    }

    /**
     * @param prCode the prCode to set
     */
    public void setPrCode(int prCode) {
        this.prCode = prCode;
    }
}
