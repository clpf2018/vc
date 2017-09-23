/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManamgement.Web.Beans;

import StockManagement.ObjectModel.ValueObject.Brand;
import StockManagement.ObjectModel.ValueObject.Product;
import StockManagement.ObjectModel.ValueObject.Supplier;
import StockManagement.Services.productClient;
import StockManagement.Services.supplierClient;
import StockManamgement.Web.Utilities.MessageView;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author mfaour
 */
@ManagedBean(name = "productBean")
@ViewScoped
public class ProductBean implements Serializable {

    private List<Product> products;
    private Product selectedProduct;
    @ManagedProperty("#{productClient}")
    private transient productClient service;
    private List<Brand> brands;

    private int productBrand;

    private Product newProduct;
    private String supplierId;

    @PostConstruct
    public void init() {
        // HttpSession session = SessionUtils.getSession();
        //Object objCompany = session.getAttribute("SelectedCompany");

        refreshData();
        newProduct = new Product();
        GenericType<List<Brand>> brdType = new GenericType<List<Brand>>() {
        };
        brands = service.getAllBrands(brdType);
    }

    public void setService(productClient service) {
        this.service = service;
    }

    private void refreshData() {
        Map<String, String> params = FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap();
        if (supplierId == null || supplierId.isEmpty()) {
            supplierId = params.get("sup_id");
        }
        GenericType<List<Product>> gType = new GenericType<List<Product>>() {
        };
        products = service.getBySupplier(gType, supplierId);
    }

    public List<Brand> getBrands() {
        return brands;
    }

    public List<Product> getProducts() {
        return products;
    }

    /**
     * @return the newProduct
     */
    public Product getNewProduct() {
        return newProduct;
    }

    /**
     * @param newProduct the newProduct to set
     */
    public void setNewProduct(Product newProduct) {
        this.newProduct = newProduct;
    }

    public void add() {
        supplierClient client = new supplierClient();
        Supplier supplier = client.get(Supplier.class, supplierId);
        newProduct.setSupplier(supplier);
        Brand prdbrand = null;
        for (int i = 0; i < brands.size(); i++) {
            if (brands.get(i).getBrdCode() == productBrand) {
                prdbrand = brands.get(i);
                break;
            }
        }
        newProduct.setBrand(prdbrand);
        service.add(newProduct, String.class);
        MessageView.Info("Info", "Product saved successfully.");
        refreshData();

    }

    public void delete() {
        service.delete(selectedProduct.getPrCode(), String.class);
        refreshData();
        MessageView.Info("Info", "Product deleted successfully.");
    }

    public void update() {
        supplierClient client = new supplierClient();
        Supplier supplier = client.get(Supplier.class, supplierId);
        if (supplier == null) {
            MessageView.Error("Error", "Error updating product.");
            return;
        }
        selectedProduct.setSupplier(supplier);

        Brand prdbrand = null;
        for (int i = 0; i < brands.size(); i++) {
            if (brands.get(i).getBrdCode() == productBrand) {
                prdbrand = brands.get(i);
                break;
            }
        }
        if (prdbrand == null) {
            MessageView.Error("Error", "Error updating product.");
            return;
        }
        selectedProduct.setBrand(prdbrand);
        service.update(selectedProduct, String.class);
        refreshData();
        MessageView.Info("Info", "Product updated successfully.");
    }

    /**
     * @return the productBrand
     */
    public int getProductBrand() {
        return productBrand;
    }

    /**
     * @param productBrand the productBrand to set
     */
    public void setProductBrand(int productBrand) {
        this.productBrand = productBrand;
    }

    /**
     * @return the selectedProduct
     */
    public Product getSelectedProduct() {
        return selectedProduct;
    }

    /**
     * @param selectedProduct the selectedProduct to set
     */
    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }
}
